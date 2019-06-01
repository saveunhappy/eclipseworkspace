package com.mypack.domain;

public class SystemUser {
    private Long id;

    private String t_username;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getT_username() {
        return t_username;
    }

    public void setT_username(String t_username) {
        this.t_username = t_username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}