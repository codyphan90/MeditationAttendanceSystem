package edu.mum.waa.entity;

import edu.mum.waa.Utils.Common;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="BLOCK")
public class BlockEntity {

    @Id
    @Column(name="blockId", nullable = false)
    private Integer blockId;

    @Column(name="Name")
    private String name;


    @Column(name="Course")
    private String course;


    @Column(name="Professor_Id")
    private Integer professorId;

    @Column(name="Start_Date")
    private LocalDate  startDate;

    @Column(name="End_Date")
    private LocalDate  endDate;

    @Column(name="Total_Date")
    private Integer totalDate;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "blockList")
    private Set<UserEntity> userList = new HashSet<>();

    public BlockEntity() {
    }

    public BlockEntity(Integer blockId, String name, String course, Integer professorId, LocalDate startDate, LocalDate endDate) {
        this.blockId = blockId;
        this.name = name;
        this.course = course;
        this.professorId = professorId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalDate = Common.calcWeekDays(startDate, endDate);
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getTotalDate() {
        return totalDate;
    }

    public void setTotalDate(Integer totalDate) {
        this.totalDate = totalDate;
    }

    public Set<UserEntity> getUserList() {
        return userList;
    }
}
