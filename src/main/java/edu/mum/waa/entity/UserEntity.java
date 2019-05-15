package edu.mum.waa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_block",
    joinColumns = {@JoinColumn(name = "User_Id")},
    inverseJoinColumns = {@JoinColumn(name="Block_Id")})
    private Set<BlockEntity> blockList = new HashSet<>();

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

    public Set<BlockEntity> getBlockList() {
        return blockList;
    }
}
