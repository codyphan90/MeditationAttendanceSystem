package edu.mum.waa;

import edu.mum.waa.entity.BlockEntity;
import edu.mum.waa.entity.RoleEntity;
import edu.mum.waa.entity.UserEntity;
import edu.mum.waa.repository.BlockRepository;
import edu.mum.waa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WaaApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlockRepository blockRepository;

	@Test
	public void contextLoads() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");

        UserEntity user1 = new UserEntity(5,"Viet Anh", "123456", new Long("987013"));
        UserEntity user2 = new UserEntity(6,"Cong Pham", "123456", new Long("987033"));
        Set<RoleEntity> roles = new HashSet<>();
        RoleEntity admin = new RoleEntity("ADMIN");
        roles.add(admin);
        user2.setRoles(roles);
        UserEntity user3 = new UserEntity(7,"Dawbeke", "123456", new Long("987044"));
        UserEntity user4 = new UserEntity(8,"Tom", "123456", null);
        UserEntity user5 = new UserEntity(9,"Xing", "123456", null);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

        BlockEntity block1 = new BlockEntity(1,"Feb 2019", "STC 2019", 8,
                LocalDate.parse("02/01/2019", formatter),
                LocalDate.parse("02/28/2019", formatter),
                20);
        BlockEntity block2 = new BlockEntity(2,"March 2019", "MPP 2019", 9,
                LocalDate.parse("03/01/2019", formatter),
                LocalDate.parse("03/31/2019", formatter),
                22);
        blockRepository.save(block1);
        blockRepository.save(block2);

        user1.getBlockList().add(block1);
        user1.getBlockList().add(block2);
        user2.getBlockList().add(block1);
        user2.getBlockList().add(block2);
        user3.getBlockList().add(block2);

        block1.getUserList().add(user1);
        block1.getUserList().add(user2);
        block2.getUserList().add(user1);
        block2.getUserList().add(user2);
        block2.getUserList().add(user3);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

        blockRepository.save(block1);
        blockRepository.save(block2);


        BlockEntity blockEntity = blockRepository.findByBlockIdEquals(2);
        System.out.println("blockEntity has some User:");
        blockEntity.getUserList().forEach( userEntity -> {
            System.out.println(userEntity.getName());
        });

        System.out.println("user has:");
        UserEntity userEntity = userRepository.findByUseridEquals(5);
        userEntity.getBlockList().forEach(blockEntity1 -> {
            System.out.println(blockEntity1.getName());
        });
	}

}
