package edu.mum.waa.repository;

import edu.mum.waa.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Integer> {

    @Query("Select count(a) from AttendanceEntity a where (a.studentId = :studentId or a.cardId = :cardId) and (a.date BETWEEN :startDate AND :endDate) and a.type = :type")
    Integer countAttend(@Param("studentId") Integer studentId,
                        @Param("cardId") Long cardId,
                        @Param("startDate") LocalDate startDate,
                        @Param("endDate") LocalDate endDate,
                        @Param("type") String type);
}
