package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
 
import java.util.Objects;

@Entity
public class HiddenGemBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String day;
    private String time;
    private int peopleNum;

    @Column(name = "hidden_gem_id", updatable = false, insertable = false)
    private int hiddenGemId;

    @ManyToOne
    private HiddenGem hiddenGem;

    @ManyToOne
    private user users;

    public HiddenGemBooking() {
    }

    public HiddenGemBooking(int id, String day, String time, int peopleNum, int hiddenGemId, HiddenGem hiddenGem, user users) {
        this.id = id;
        this.day = day;
        this.time = time;
        this.peopleNum = peopleNum;
        this.hiddenGemId = hiddenGemId;
        this.hiddenGem = hiddenGem;
        this.users = users;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPeopleNum() {
        return this.peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public int getHiddenGemId() {
        return this.hiddenGemId;
    }

    public void setHiddenGemId(int hiddenGemId) {
        this.hiddenGemId = hiddenGemId;
    }

    public HiddenGem getHiddenGem() {
        return this.hiddenGem;
    }

    public void setHiddenGem(HiddenGem hiddenGem) {
        this.hiddenGem = hiddenGem;
    }

    public user getUsers() {
        return this.users;
    }

    public void setUsers(user users) {
        this.users = users;
    }

    public HiddenGemBooking id(int id) {
        setId(id);
        return this;
    }

    public HiddenGemBooking day(String day) {
        setDay(day);
        return this;
    }

    public HiddenGemBooking time(String time) {
        setTime(time);
        return this;
    }

    public HiddenGemBooking peopleNum(int peopleNum) {
        setPeopleNum(peopleNum);
        return this;
    }

    public HiddenGemBooking hiddenGemId(int hiddenGemId) {
        setHiddenGemId(hiddenGemId);
        return this;
    }

    public HiddenGemBooking hiddenGem(HiddenGem hiddenGem) {
        setHiddenGem(hiddenGem);
        return this;
    }

    public HiddenGemBooking users(user users) {
        setUsers(users);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HiddenGemBooking)) {
            return false;
        }
        HiddenGemBooking hiddenGemBooking = (HiddenGemBooking) o;
        return id == hiddenGemBooking.id && Objects.equals(day, hiddenGemBooking.day) && Objects.equals(time, hiddenGemBooking.time) && peopleNum == hiddenGemBooking.peopleNum && hiddenGemId == hiddenGemBooking.hiddenGemId && Objects.equals(hiddenGem, hiddenGemBooking.hiddenGem) && Objects.equals(users, hiddenGemBooking.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day, time, peopleNum, hiddenGemId, hiddenGem, users);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", day='" + getDay() + "'" +
            ", time='" + getTime() + "'" +
            ", peopleNum='" + getPeopleNum() + "'" +
            ", hiddenGemId='" + getHiddenGemId() + "'" +
            ", hiddenGem='" + getHiddenGem() + "'" +
            ", users='" + getUsers() + "'" +
            "}";
    }

}