package edu.mum.waa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class UserEntity {
    @Id
    @Column(name="id", nullable = false)
    private Integer userId;

    @Column(name="Name")
    private String name;

    @Column(name="Password")
    private String password;

    @Column(name="Card_Id")
    private Long cardId;

    @Column(name="Role")
    private String role;

    public UserEntity() {
    }

    public UserEntity(Integer id, String name, String password, Long cardId, String role) {
        this.userId = id;
        this.name = name;
        this.password = password;
        this.cardId = cardId;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
