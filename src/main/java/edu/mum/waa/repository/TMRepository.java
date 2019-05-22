package edu.mum.waa.repository;





import edu.mum.waa.entity.TM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface TMRepository extends JpaRepository<TM,Long>{
    @Query(value = "select tm from TM tm  where tm.checkedDate= :checkedDate")
    List<TM> checkDuplicate(@Param ("checkedDate") LocalDate checkedDate);

    @Query(value = "select tm from TM tm  where tm.student.studentId= :studentId")
    List<TM>findAllTmChecksOfStudent(@Param("studentId") long id);
}


