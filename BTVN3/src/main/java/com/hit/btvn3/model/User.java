package com.hit.btvn3.model;

public class User {

    private static int id = 0;

    private String username;
    private String password;
    private String fullname;

    public User() {
        id++;
    }

    public User(String username, String password, String fullname) {
        id++;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    public static int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}
