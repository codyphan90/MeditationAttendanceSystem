package edu.mum.waa.service;

import edu.mum.waa.Utils.Common;
import edu.mum.waa.entity.AttendDetail;
import edu.mum.waa.entity.BlockEntity;
import edu.mum.waa.entity.UserEntity;
import edu.mum.waa.repository.AttendanceRepository;
import edu.mum.waa.repository.BlockRepository;
import edu.mum.waa.repository.UserRepository;
import edu.mum.waa.response.StudentReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private UserRepository userRepository;

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public List<StudentReport> getBlockReportOfAllStudent(Integer blockId) {
        BlockEntity blockEntity = blockRepository.findByBlockIdEquals(blockId);
        List<StudentReport> studentReports = new ArrayList<>();
        if (blockEntity == null) return studentReports;
        blockEntity.getUserList().forEach(student -> {
            Integer attendedCount = countAttendanceTM(student, blockEntity);
            Integer sessionTotal = blockEntity.getTotalDate();
            Double percent = new Double(df2.format((double) attendedCount.doubleValue() / sessionTotal.doubleValue() * 100));
            StudentReport studentReport = new StudentReport(student.getUserid(), attendedCount, sessionTotal, percent, convertBonus(percent));
            studentReports.add(studentReport);
        });
        Collections.sort(studentReports);
        return studentReports;
    }
    public StudentReport getBlockReportOfStudent(Integer blockId, Integer studentId) {
        BlockEntity blockEntity = blockRepository.findByBlockIdEquals(blockId);
        UserEntity student = userRepository.findByUseridEquals(studentId);
        Integer attendedCount = countAttendanceTM(student, blockEntity);
        Double percent = new Double(df2.format((double) attendedCount.doubleValue() / blockEntity.getTotalDate().doubleValue() * 100));
        return new StudentReport(student.getUserid(), attendedCount, blockEntity.getTotalDate(), percent, convertBonus(percent));
    }

    public List<StudentReport> getEntryReport(String entryId) {
        List<UserEntity> userEntities = userRepository.findAllByEntryEquals(entryId);
        List<StudentReport> studentReports = new ArrayList<>();
        userEntities.forEach(student -> {
            studentReports.add(getAllAttendedOfStudent(student));
        });
        return studentReports;
    }

    public StudentReport getAllAttendedOfStudent(UserEntity student) {
        Integer sessionTotal = 0;
        Integer totalAttended = 0;
        for (BlockEntity blockEntity : student.getBlockList()) {
            sessionTotal += blockEntity.getTotalDate();
            totalAttended += countAttendanceTM(student, blockEntity);
        }
        Double percent = totalAttended == 0 ? 0 : new Double(df2.format((double) totalAttended.doubleValue() / sessionTotal.doubleValue() * 100));
        return new StudentReport(student.getUserid(), totalAttended, sessionTotal, percent, convertBonus(percent));
    }

    public List<AttendDetail> getAttendRecord(Integer blockId, Integer studentId) {
        BlockEntity blockEntity = blockRepository.findByBlockIdEquals(blockId);
        UserEntity student = userRepository.findByUseridEquals(studentId);
        List<LocalDate> localDates = Common.getAllDateOfBlock(blockEntity);
        List<AttendDetail> attendDetails = new ArrayList<>();
        localDates.forEach(localDate -> {
            AttendDetail attendDetail = new AttendDetail();
            attendDetail.setDate(localDate.toString());
            attendDetail.setAttended(attendanceRepository.getAttendedRecord(studentId, student.getCardId() ,localDate, "AM") == 1);
            attendDetails.add(attendDetail);
        });
        return attendDetails;
    }

    public Integer countAttendanceTM(UserEntity student, BlockEntity blockEntity) {
        return attendanceRepository.countAttend(student.getUserid(), student.getCardId(),
                blockEntity.getStartDate(), blockEntity.getEndDate(), "AM");
    }

    public Double convertBonus(Double percent) {
        if (percent < 70) return 0.0;
        if (percent >= 70 && percent < 80) return 0.5;
        if (percent >= 80 && percent < 90) return 1.0;
        if (percent >= 90) return 1.5;
        return 0.0;
    }
}
