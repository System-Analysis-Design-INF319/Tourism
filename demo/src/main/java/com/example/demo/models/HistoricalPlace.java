package com.example.demo.models;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class HistoricalPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String description;
    private String location;
    private String image;
    private String startDay;
    private String endDay;
    private LocalTime startWorkingTime;
    private LocalTime endWorkingTime;



    public HistoricalPlace() {
    }

    public HistoricalPlace(int id, String name, String city, String description, String location, String image, String startDay, String endDay, LocalTime startWorkingTime, LocalTime endWorkingTime) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.description = description;
        this.location = location;
        this.image = image;
        this.startDay = startDay;
        this.endDay = endDay;
        this.startWorkingTime = startWorkingTime;
        this.endWorkingTime = endWorkingTime;
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

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStartDay() {
        return this.startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return this.endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public LocalTime getStartWorkingTime() {
        return this.startWorkingTime;
    }

    public void setStartWorkingTime(LocalTime startWorkingTime) {
        this.startWorkingTime = startWorkingTime;
    }

    public LocalTime getEndWorkingTime() {
        return this.endWorkingTime;
    }

    public void setEndWorkingTime(LocalTime endWorkingTime) {
        this.endWorkingTime = endWorkingTime;
    }

    public HistoricalPlace id(int id) {
        setId(id);
        return this;
    }

    public HistoricalPlace name(String name) {
        setName(name);
        return this;
    }

    public HistoricalPlace city(String city) {
        setCity(city);
        return this;
    }

    public HistoricalPlace description(String description) {
        setDescription(description);
        return this;
    }

    public HistoricalPlace location(String location) {
        setLocation(location);
        return this;
    }

    public HistoricalPlace image(String image) {
        setImage(image);
        return this;
    }

    public HistoricalPlace startDay(String startDay) {
        setStartDay(startDay);
        return this;
    }

    public HistoricalPlace endDay(String endDay) {
        setEndDay(endDay);
        return this;
    }

    public HistoricalPlace startWorkingTime(LocalTime startWorkingTime) {
        setStartWorkingTime(startWorkingTime);
        return this;
    }

    public HistoricalPlace endWorkingTime(LocalTime endWorkingTime) {
        setEndWorkingTime(endWorkingTime);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HistoricalPlace)) {
            return false;
        }
        HistoricalPlace historicalPlace = (HistoricalPlace) o;
        return id == historicalPlace.id && Objects.equals(name, historicalPlace.name) && Objects.equals(city, historicalPlace.city) && Objects.equals(description, historicalPlace.description) && Objects.equals(location, historicalPlace.location) && Objects.equals(image, historicalPlace.image) && Objects.equals(startDay, historicalPlace.startDay) && Objects.equals(endDay, historicalPlace.endDay) && Objects.equals(startWorkingTime, historicalPlace.startWorkingTime) && Objects.equals(endWorkingTime, historicalPlace.endWorkingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, description, location, image, startDay, endDay, startWorkingTime, endWorkingTime);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", city='" + getCity() + "'" +
            ", description='" + getDescription() + "'" +
            ", location='" + getLocation() + "'" +
            ", image='" + getImage() + "'" +
            ", startDay='" + getStartDay() + "'" +
            ", endDay='" + getEndDay() + "'" +
            ", startWorkingTime='" + getStartWorkingTime() + "'" +
            ", endWorkingTime='" + getEndWorkingTime() + "'" +
            "}";
    }    
    
}
