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
    private Long cardId;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "Type")
    private String type;

    @Column(name = "Location")
    private String location;

    public AttendanceEntity() {
    }

    public AttendanceEntity(Integer studentId, LocalDate date, String type) {
        this.studentId = studentId;
        this.date = date;
        this.type = type;
    }

    public AttendanceEntity(Long cardId, LocalDate date, String type, String location) {
        this.cardId = cardId;
        this.date = date;
        this.type = type;
        this.location = location;
    }

    public AttendanceEntity(Integer studentId, Long cardId, LocalDate date, String type, String location) {
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

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
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

    @Override
    public boolean equals(Object obj) {
        AttendanceEntity attendanceEntity = (AttendanceEntity) obj;
        if (attendanceEntity == null) return false;
        Integer id = this.studentId == null ? 0 : this.studentId;
        Long card = this.cardId == null ? 0L : this.cardId;
        Integer id1 = attendanceEntity.studentId == null ? 0 : attendanceEntity.studentId;
        Long card1 = attendanceEntity.cardId == null ? 0L : attendanceEntity.cardId;
        return  id.equals(id1)
                && card.equals(card1)
                && this.date.equals(attendanceEntity.date)
                && this.type.equals(attendanceEntity.type);
    }
}
