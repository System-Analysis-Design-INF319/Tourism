package com.example.demo.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class HiddenGemSchedule {
    private String day;
    
    @ElementCollection
    private List<String> hours;


    public HiddenGemSchedule() {
    }

    public HiddenGemSchedule(String day, List<String> hours) {
        this.day = day;
        this.hours = hours;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<String> getHours() {
        return this.hours;
    }

    public void setHours(List<String> hours) {
        this.hours = hours;
    }

    public HiddenGemSchedule day(String day) {
        setDay(day);
        return this;
    }

    public HiddenGemSchedule hours(List<String> hours) {
        setHours(hours);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HiddenGemSchedule)) {
            return false;
        }
        HiddenGemSchedule hiddenGemSchedule = (HiddenGemSchedule) o;
        return Objects.equals(day, hiddenGemSchedule.day) && Objects.equals(hours, hiddenGemSchedule.hours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, hours);
    }

    @Override
    public String toString() {
        return "{" +
            " day='" + getDay() + "'" +
            ", hours='" + getHours() + "'" +
            "}";
    }
    
}
