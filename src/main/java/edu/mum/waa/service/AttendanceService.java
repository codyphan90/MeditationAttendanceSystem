package edu.mum.waa.service;

import edu.mum.waa.entity.AttendanceEntity;
import edu.mum.waa.entity.BlockEntity;
import edu.mum.waa.entity.UserEntity;
import edu.mum.waa.repository.AttendanceRepository;
import edu.mum.waa.repository.BlockRepository;
import edu.mum.waa.repository.UserRepository;
import edu.mum.waa.response.StudentReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<StudentReport> getReport(Integer blockId) {
        BlockEntity blockEntity = blockRepository.findByBlockIdEquals(blockId);
        List<StudentReport> studentReports = new ArrayList<>();
        if(blockEntity == null) return studentReports;
        blockEntity.getUserList().forEach(student -> {
                Integer attendedCount = countAttendance(student, blockEntity);
                Integer sessionTotal = blockEntity.getTotalDate();
                Double percent = (double) Math.round(attendedCount.doubleValue() / sessionTotal.doubleValue() * 100);
                StudentReport studentReport = new StudentReport(blockEntity.getName(), student.getName(), attendedCount, sessionTotal, percent, convertBonus(percent));
                studentReports.add(studentReport);
        });
        Collections.sort(studentReports);
        return studentReports;
    }

    public Integer countAttendance(UserEntity student, BlockEntity blockEntity) {
        return attendanceRepository.countAttend(student.getUserid(), student.getCardId(),
                blockEntity.getStartDate(), blockEntity.getEndDate());
    }

    public Double convertBonus(Double percent) {
        if (percent<70) return 0.0;
        if (percent >= 70 && percent < 80) return 0.5;
        if (percent >= 80 && percent < 90) return 1.0;
        if (percent >=90) return 1.5;
        return 0.0;
    }
}