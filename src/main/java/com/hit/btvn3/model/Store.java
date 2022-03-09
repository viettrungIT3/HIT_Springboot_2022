package com.hit.btvn3.model;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User("admin", "abc@123", "Admin"));
        users.add(new User("Trung123", "abc@123", "Nguyễn Việt Trung"));
        users.add(new User("Trung1234", "abc@123", "Nguyễn Việt Trung"));
    }

    public Store() {
    }

    public Store(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
