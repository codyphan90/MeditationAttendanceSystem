package edu.mum.waa.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Data
@Table(name="TM")
public class TM implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkedDate;
    private String tmType;

    @Valid
    @ManyToOne(cascade={CascadeType.REMOVE})
    @JoinColumn(name="student_id")
    private Student student;

}
