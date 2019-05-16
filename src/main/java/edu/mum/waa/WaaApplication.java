package edu.mum.waa;

import edu.mum.waa.entity.AttendanceEntity;
import edu.mum.waa.entity.BlockEntity;
import edu.mum.waa.entity.UserEntity;
import edu.mum.waa.repository.AttendanceRepository;
import edu.mum.waa.repository.BlockRepository;
import edu.mum.waa.repository.UserRepository;
import edu.mum.waa.service.AttendanceService;
import edu.mum.waa.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@SpringBootApplication
public class WaaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WaaApplication.class, args);
	}

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private BlockService blockService;

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");

        UserEntity user1 = new UserEntity(5,"Viet Anh", "123456", new Long("987013"));
        UserEntity user2 = new UserEntity(6,"Cong Pham", "123456", new Long("987033"));
        UserEntity user3 = new UserEntity(7,"Dawbeke", "123456", new Long("987044"));
        UserEntity user4 = new UserEntity(8,"Tom", "123456", null);
        UserEntity user5 = new UserEntity(9,"Xing", "123456", null);

        BlockEntity block1 = new BlockEntity(1,"Feb2019", "STC", 8,
                LocalDate.parse("02/01/2019", formatter),
                LocalDate.parse("02/28/2019", formatter),
                20);
        BlockEntity block2 = new BlockEntity(2,"March2019", "WAP", 9,
                LocalDate.parse("03/01/2019", formatter),
                LocalDate.parse("03/31/2019", formatter),
                22);

        BlockEntity block3 = new BlockEntity(3,"April2019", "WAA", 9,
                LocalDate.parse("04/01/2019", formatter),
                LocalDate.parse("04/30/2019", formatter),
                22);

        blockService.assignUserToBlock(user1, block1);
        blockService.assignUserToBlock(user1, block2);
        blockService.assignUserToBlock(user2, block1);
        blockService.assignUserToBlock(user2, block2);
        blockService.assignUserToBlock(user3, block2);
        blockService.assignUserToBlock(user3, block3);

//        BlockEntity blockEntity = blockRepository.findByBlockIdEquals(2);
//        System.out.println("blockEntity has some User:");
//        blockEntity.getUserList().forEach( userEntity -> {
//            System.out.println(userEntity.getName());
//        });
//
//        System.out.println("user has:");
//        UserEntity userEntity = userRepository.findByUseridEquals(5);
//        userEntity.getBlockList().forEach(blockEntity1 -> {
//            System.out.println(blockEntity1.getName());
//        });


        //Create Attendance data
        AttendanceEntity attendanceEntity1 = new AttendanceEntity(5, null,
                LocalDate.parse("02/20/2019", formatter), "AM", "DB");

        AttendanceEntity attendanceEntity2 = new AttendanceEntity(5, null,
                LocalDate.parse("02/21/2019", formatter), "AM", "DB");

        AttendanceEntity attendanceEntity3 = new AttendanceEntity(null, new Long("987013"),
                LocalDate.parse("03/13/2019", formatter), "AM", "DB");

        AttendanceEntity attendanceEntity4 = new AttendanceEntity(null, new Long("987013"),
                LocalDate.parse("03/15/2019", formatter), "AM", "DB");

        AttendanceEntity attendanceEntity5 = new AttendanceEntity(null, new Long("987013"),
                LocalDate.parse("03/16/2019", formatter), "AM", "DB");

        AttendanceEntity attendanceEntity6 = new AttendanceEntity(null, new Long("987013"),
                LocalDate.parse("03/17/2019", formatter), "AM", "DB");

        AttendanceEntity attendanceEntity7 = new AttendanceEntity(null, new Long("987033"),
                LocalDate.parse("02/20/2019", formatter), "AM", "DB");

        AttendanceEntity attendanceEntity8 = new AttendanceEntity(null, new Long("987044"),
                LocalDate.parse("03/01/2019", formatter), "AM", "DB");

        AttendanceEntity attendanceEntity9 = new AttendanceEntity(null, new Long("987044"),
                LocalDate.parse("04/01/2019", formatter), "AM", "DB");


        attendanceRepository.save(attendanceEntity1);
        attendanceRepository.save(attendanceEntity2);
        attendanceRepository.save(attendanceEntity3);
        attendanceRepository.save(attendanceEntity4);
        attendanceRepository.save(attendanceEntity5);
        attendanceRepository.save(attendanceEntity6);
        attendanceRepository.save(attendanceEntity7);
        attendanceRepository.save(attendanceEntity8);
        attendanceRepository.save(attendanceEntity9);

//        attendanceService.getReport(2);

    }
}
