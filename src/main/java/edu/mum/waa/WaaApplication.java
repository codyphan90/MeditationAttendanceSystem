package edu.mum.waa;

import edu.mum.waa.Utils.Common;
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

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
    @Transactional
    public void run(String... args) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");

//        UserEntity user1 = new UserEntity(987013,"Viet Anh", "$2a$10$fTbfbqSI0voIRsw1Nrmhj.AoaTuw79uF835uS/UKMyA.tShv9F2AS\n", new Long("11001000987013"), "Feb2019");
        UserEntity user1 = userRepository.findByUseridEquals(987013);
        UserEntity user2 = userRepository.findByUseridEquals(987014);
        UserEntity user3 = userRepository.findByUseridEquals(987015);

        BlockEntity block1 = new BlockEntity(1,"Feb2019", "STC", 3,
                LocalDate.parse("02/01/2019", formatter),
                LocalDate.parse("02/26/2019", formatter));

        BlockEntity block2 = new BlockEntity(2,"March2019", "WAP", 3,
                LocalDate.parse("03/01/2019", formatter),
                LocalDate.parse("03/26/2019", formatter));

        BlockEntity block3 = new BlockEntity(3,"April2019", "WAA", 3,
                LocalDate.parse("04/01/2019", formatter),
                LocalDate.parse("04/25/2019", formatter));

        BlockEntity block4 = new BlockEntity(11,"November2016", "EA", 3,
                LocalDate.parse("11/01/2016", formatter),
                LocalDate.parse("11/25/2016", formatter));


        BlockEntity block5 = new BlockEntity(12,"December2018", "ASD", 4,
                LocalDate.parse("12/01/2018", formatter),
                LocalDate.parse("12/26/2018", formatter));

        BlockEntity block6 = new BlockEntity(13,"January2017", "DBMS", 4,
                LocalDate.parse("01/01/2017", formatter),
                LocalDate.parse("01/25/2017", formatter));

        blockRepository.save(block1);
        blockRepository.save(block2);
        blockRepository.save(block3);
        blockRepository.save(block4);
        blockRepository.save(block5);
        blockRepository.save(block6);


        blockService.assignUserToBlock(user1, block1);
        blockService.assignUserToBlock(user1, block2);
        blockService.assignUserToBlock(user1, block3);
        blockService.assignUserToBlock(user2, block1);
        blockService.assignUserToBlock(user2, block2);
        blockService.assignUserToBlock(user3, block2);
        blockService.assignUserToBlock(user3, block3);
        blockService.assignUserToBlock(user3, block5);


        LocalDate start = LocalDate.parse("03/1/2019", formatter);
        LocalDate end = LocalDate.parse("03/23/2019", formatter);
        while (!start.isAfter(end)) {
            if (start.getDayOfWeek() != DayOfWeek.SUNDAY) {
                AttendanceEntity attendanceEntity = new AttendanceEntity(null, new Long("11001000987013"),
                        start, "AM", "DB");
                attendanceRepository.save(attendanceEntity);
            }
            start = start.plusDays(1);
        }
        AttendanceEntity attendanceEntity1 = new AttendanceEntity(987013, null,
                LocalDate.parse("03/25/2019", formatter), "AM", "DB");


        for (int i = 1; i < 18; i++) {
            String date = "03/" + i +"/2019";
            AttendanceEntity attendanceEntity = new AttendanceEntity(null, new Long("11001000987014"),
                    LocalDate.parse(date, formatter), "AM", "DB");
            attendanceRepository.save(attendanceEntity);
        }

        AttendanceEntity attendanceEntity8 = new AttendanceEntity(null, new Long("11001000987015"),
                LocalDate.parse("12/22/2018", formatter), "AM", "DB");

        AttendanceEntity attendanceEntity9 = new AttendanceEntity(null, new Long("11001000987015"),
                LocalDate.parse("04/01/2019", formatter), "AM", "DB");

        attendanceRepository.save(attendanceEntity1);
        attendanceRepository.save(attendanceEntity8);
        attendanceRepository.save(attendanceEntity9);
    }
}
