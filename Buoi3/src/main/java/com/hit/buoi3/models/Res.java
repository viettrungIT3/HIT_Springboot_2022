package com.hit.buoi3.models;

import java.util.List;

public class Res {

    private String messege;
    private List<User> user;

    public Res() {
    }

    public Res(String messege, List<User> user) {
        this.messege = messege;
        this.user = user;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
