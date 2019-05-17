package edu.mum.waa.repository;

import edu.mum.waa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity  findByUseridEquals (Integer id);
    UserEntity findByCardIdEquals (Long cardId);
    List<UserEntity> findAllByEntryEquals(String entryId);
}
