package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class LocalBusinessOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;


    public LocalBusinessOwner() {
    }

    public LocalBusinessOwner(int id, String name, String email, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
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

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalBusinessOwner id(int id) {
        setId(id);
        return this;
    }

    public LocalBusinessOwner name(String name) {
        setName(name);
        return this;
    }

    public LocalBusinessOwner email(String email) {
        setEmail(email);
        return this;
    }

    public LocalBusinessOwner phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public LocalBusinessOwner password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LocalBusinessOwner)) {
            return false;
        }
        LocalBusinessOwner localBusinessOwner = (LocalBusinessOwner) o;
        return id == localBusinessOwner.id && Objects.equals(name, localBusinessOwner.name) && Objects.equals(email, localBusinessOwner.email) && Objects.equals(phoneNumber, localBusinessOwner.phoneNumber) && Objects.equals(password, localBusinessOwner.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phoneNumber, password);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
        
}