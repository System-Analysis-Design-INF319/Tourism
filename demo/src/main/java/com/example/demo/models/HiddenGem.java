package com.example.demo.models;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Objects;

@Entity
public class HiddenGem {
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


    public HiddenGem() {
    }

    public HiddenGem(int id, String name, String city, String description, String location, String image, String startDay, String endDay, LocalTime startWorkingTime, LocalTime endWorkingTime) {
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

    public HiddenGem id(int id) {
        setId(id);
        return this;
    }

    public HiddenGem name(String name) {
        setName(name);
        return this;
    }

    public HiddenGem city(String city) {
        setCity(city);
        return this;
    }

    public HiddenGem description(String description) {
        setDescription(description);
        return this;
    }

    public HiddenGem location(String location) {
        setLocation(location);
        return this;
    }

    public HiddenGem image(String image) {
        setImage(image);
        return this;
    }

    public HiddenGem startDay(String startDay) {
        setStartDay(startDay);
        return this;
    }

    public HiddenGem endDay(String endDay) {
        setEndDay(endDay);
        return this;
    }

    public HiddenGem startWorkingTime(LocalTime startWorkingTime) {
        setStartWorkingTime(startWorkingTime);
        return this;
    }

    public HiddenGem endWorkingTime(LocalTime endWorkingTime) {
        setEndWorkingTime(endWorkingTime);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HiddenGem)) {
            return false;
        }
        HiddenGem hiddenGem = (HiddenGem) o;
        return id == hiddenGem.id && Objects.equals(name, hiddenGem.name) && Objects.equals(city, hiddenGem.city) && Objects.equals(description, hiddenGem.description) && Objects.equals(location, hiddenGem.location) && Objects.equals(image, hiddenGem.image) && Objects.equals(startDay, hiddenGem.startDay) && Objects.equals(endDay, hiddenGem.endDay) && Objects.equals(startWorkingTime, hiddenGem.startWorkingTime) && Objects.equals(endWorkingTime, hiddenGem.endWorkingTime);
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

    
    public ArrayList<String> getDays(String startDay, String endDay){
        DayOfWeek start = DayOfWeek.valueOf(startDay.toUpperCase());
        DayOfWeek end = DayOfWeek.valueOf(endDay.toUpperCase());	
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE");
        ArrayList<String> days = new ArrayList<String>();

        while (currentDate.getDayOfWeek() != start) {
            currentDate = currentDate.plusDays(1);
        }
        while (currentDate.getDayOfWeek() != end) {
            days.add(currentDate.format(formatter));
            currentDate = currentDate.plusDays(1);
        }
        days.add(endDay);
        return days;
    }

    public ArrayList<String> getTime(LocalTime startWorkingTime,LocalTime endWorkingTime){
        ArrayList<String> hours = new ArrayList<String>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        while (startWorkingTime.isBefore(endWorkingTime) || startWorkingTime.equals(endWorkingTime)) {
            String formattedHour = startWorkingTime.format(formatter);
            hours.add(formattedHour);
            startWorkingTime = startWorkingTime.plusHours(1); // Add an hour
        }
        return hours;
    }

}
