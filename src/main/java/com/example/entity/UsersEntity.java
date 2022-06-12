package com.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "pooproject", catalog = "")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idusers")
    private int idusers;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "user")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;

    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return idusers == that.idusers && Objects.equals(email, that.email) &&
                Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idusers, email, username, password);
    }
}
