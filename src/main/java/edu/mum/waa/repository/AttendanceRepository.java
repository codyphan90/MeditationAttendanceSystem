package edu.mum.waa.repository;

import edu.mum.waa.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Integer> {
}
