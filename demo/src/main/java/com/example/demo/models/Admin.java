package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Admin {
    @Id
    private int id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;


    public Admin() {
    }

    public Admin(int id, String name, String email, String password, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Admin id(int id) {
        setId(id);
        return this;
    }

    public Admin name(String name) {
        setName(name);
        return this;
    }

    public Admin email(String email) {
        setEmail(email);
        return this;
    }

    public Admin password(String password) {
        setPassword(password);
        return this;
    }

    public Admin phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Admin)) {
            return false;
        }
        Admin admin = (Admin) o;
        return id == admin.id && Objects.equals(name, admin.name) && Objects.equals(email, admin.email) && Objects.equals(password, admin.password) && Objects.equals(phoneNumber, admin.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, phoneNumber);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            "}";
    }

    }
    