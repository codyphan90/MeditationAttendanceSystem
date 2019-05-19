package edu.mum.waa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="student")
public class Student implements Serializable {

    @Id
    public long student_id;

    @Column(name="First_Name")
    private String firstName;

    @Column(name="Last_Name")
    private String lastName;

    @Column(name="Entry")
    private String  entry;
    @OneToMany(mappedBy = "student", cascade =CascadeType.ALL)
    private List<TM> tmCheckList;


}
