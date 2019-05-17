package edu.mum.waa.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="USER")
public class UserEntity {


    @Id
    @Column(name="id", nullable = false)
    private Integer userid;

    @Column(name="Name")
    private String name;

    @Column(name="Password", nullable = false)
    @NotEmpty
    private String password;

    @Column(name="Card_Id")
    private Long cardId;

    @Column(name = "Active")
    private int active = 1;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_block",
    joinColumns = {@JoinColumn(name = "User_Id")},
    inverseJoinColumns = {@JoinColumn(name="Block_Id")})
    private Set<BlockEntity> blockList = new HashSet<>();

    @Column(name="Entry")
    private String entry;

    public UserEntity() {
    }

    public UserEntity(Integer userId, String name, String password, Long cardId, String entry) {
        this.userid = userId;
        this.name = name;
        this.password = password;
        this.cardId = cardId;
        this.entry = entry;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
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

    public Set<BlockEntity> getBlockList() {
        return blockList;
    }

    public void setBlockList(Set<BlockEntity> blockList) {
        this.blockList = blockList;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getActive() {
        return active;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
