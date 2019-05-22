package edu.mum.waa.entity;


import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Data
@Table(name="TM")
public class TM implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @PastOrPresent(message="Tm check date must be current or past")
    @NotNull(message = "Date must not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkedDate;

    @NotBlank(message = "TM type must be chosen")
    private String tmType;

    @Valid
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

}
