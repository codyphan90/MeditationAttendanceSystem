package edu.mum.waa.service;

import edu.mum.waa.entity.AttendanceEntity;
import edu.mum.waa.entity.BlockEntity;
import edu.mum.waa.entity.UserEntity;
import edu.mum.waa.repository.AttendanceRepository;
import edu.mum.waa.repository.BlockRepository;
import edu.mum.waa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private UserRepository userRepository;

    public Integer getReport(String blockName) {
        List<AttendanceEntity> attendanceEntities = new ArrayList<>();
        BlockEntity blockEntity = blockRepository.findByNameEquals(blockName);
        blockEntity.getUserList().forEach(student -> {
            attendanceEntities.addAll(findAttendanceList(student, blockEntity));
        });
        return attendanceEntities.size();
    }

    public List<AttendanceEntity> findAttendanceList(UserEntity student, BlockEntity blockEntity) {
        return attendanceRepository.findAttendanceInBlock(student.getUserId(), student.getCardId(),
                blockEntity.getStartDate(), blockEntity.getEndDate());
    }
}
