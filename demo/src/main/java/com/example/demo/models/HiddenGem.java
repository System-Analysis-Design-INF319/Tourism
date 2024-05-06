package com.example.demo.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @ElementCollection
    private List<String> days;

    @ElementCollection
    private List<String> hours;


    public HiddenGem() {
    }

    public HiddenGem(int id, String name, String city, String description, String location, String image, List<String> days, List<String> hours) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.description = description;
        this.location = location;
        this.image = image;
        this.days = days;
        this.hours = hours;
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

    public List<String> getDays() {
        return this.days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public List<String> getHours() {
        return this.hours;
    }

    public void setHours(List<String> hours) {
        this.hours = hours;
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

    public HiddenGem days(List<String> days) {
        setDays(days);
        return this;
    }

    public HiddenGem hours(List<String> hours) {
        setHours(hours);
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
        return id == hiddenGem.id && Objects.equals(name, hiddenGem.name) && Objects.equals(city, hiddenGem.city) && Objects.equals(description, hiddenGem.description) && Objects.equals(location, hiddenGem.location) && Objects.equals(image, hiddenGem.image) && Objects.equals(days, hiddenGem.days) && Objects.equals(hours, hiddenGem.hours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, description, location, image, days, hours);
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
            ", days='" + getDays() + "'" +
            ", hours='" + getHours() + "'" +
            "}";
    }
    
}
