package edu.mum.waa.repository;


import edu.mum.waa.entity.TM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TMRepository extends JpaRepository<TM,Long> {
}
