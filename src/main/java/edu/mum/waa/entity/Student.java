package edu.mum.waa.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="student")
public class Student implements Serializable {

    @Range(min=111, max=999, message ="Id must be in the range 111 to 999")
    @Id
    public long studentId;

    @Column(name="First_Name")
    private String firstName;

    @Column(name="Last_Name")
    private String lastName;

    @Column(name="Entry")
    private String  entry;
    @OneToMany(mappedBy = "student", cascade =CascadeType.ALL)
    private List<TM> tmCheckList;


}
