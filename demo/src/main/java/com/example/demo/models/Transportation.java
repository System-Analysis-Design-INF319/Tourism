package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;
@Entity
public class Transportation {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String from;
    private String to;
    private String price;
    private String time;

    public Transportation() {
    }

    public Transportation(int id, String from, String to, String price, String time) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.price = price;
        this.time = time;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Transportation id(int id) {
        setId(id);
        return this;
    }

    public Transportation from(String from) {
        setFrom(from);
        return this;
    }

    public Transportation to(String to) {
        setTo(to);
        return this;
    }

    public Transportation price(String price) {
        setPrice(price);
        return this;
    }

    public Transportation time(String time) {
        setTime(time);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transportation)) {
            return false;
        }
        Transportation transportation = (Transportation) o;
        return id == transportation.id && Objects.equals(from, transportation.from) && Objects.equals(to, transportation.to) && Objects.equals(price, transportation.price) && Objects.equals(time, transportation.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, price, time);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", from='" + getFrom() + "'" +
            ", to='" + getTo() + "'" +
            ", price='" + getPrice() + "'" +
            ", time='" + getTime() + "'" +
            "}";
    }

    // public void save(Transportation transportation) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'save'");
    // }

}