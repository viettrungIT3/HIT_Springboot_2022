package com.hit.btvn4.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @Nationalized   // viết tiếng việt
    @Column(name = "fullName")
    private String fullName;

    @CreationTimestamp
    @Column(name = "timeCreated")
    private Timestamp timeCreated;

    @UpdateTimestamp
    @Column(name = "timeUpdated")
    private Timestamp timeUpdated;

    public User() {
    }

    public User(Long id, String username, String password, String fullName, Timestamp timeCreated, Timestamp timeUpdated) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.timeCreated = timeCreated;
        this.timeUpdated = timeUpdated;
    }

    public User(Long id, String username, String password, String fullName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Timestamp getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Timestamp timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!username.equals(user.username))
            return false;
        return password.equals(user.password);
    }




}
