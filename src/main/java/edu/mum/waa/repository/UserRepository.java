package edu.mum.waa.repository;

import edu.mum.waa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity  findByUseridEquals (Integer id);
}
