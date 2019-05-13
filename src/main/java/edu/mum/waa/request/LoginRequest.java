package edu.mum.waa.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.mum.waa.entity.UserEntity;

public class LoginRequest {
    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("password")
    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
