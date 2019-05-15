package edu.mum.waa.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="ATTENDANCE")
public class AttendanceEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "Student_Id")
    private Integer studentId;


    @Column(name = "Card_Id")
    private Integer cardId;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "Type")
    private String type;

    @Column(name = "Location")
    private String location;

    public AttendanceEntity() {
    }

    public AttendanceEntity(Integer studentId, Integer cardId, LocalDate date, String type, String location) {
        this.studentId = studentId;
        this.cardId = cardId;
        this.date = date;
        this.type = type;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
