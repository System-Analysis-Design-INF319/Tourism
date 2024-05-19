package com.example.demo.models;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
public class BusBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String source;
    private String destination;
    private double price;
    private LocalTime time;
    private int capacity;

    @Column(name = "user_id", updatable = false, insertable = false)
    private Long userId;

    @Column(name = "bus_id", updatable = false, insertable = false)
    private int busId;
    
    @ManyToOne
    user user;
    
    @ManyToOne
    Bus bus;


    public BusBooking() {
    }

    public BusBooking(int id, String source, String destination, double price, LocalTime time, int capacity, Long userId, int busId, user user, Bus bus) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.time = time;
        this.capacity = capacity;
        this.userId = userId;
        this.busId = busId;
        this.user = user;
        this.bus = bus;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getBusId() {
        return this.busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public user getUser() {
        return this.user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public Bus getBus() {
        return this.bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public BusBooking id(int id) {
        setId(id);
        return this;
    }

    public BusBooking source(String source) {
        setSource(source);
        return this;
    }

    public BusBooking destination(String destination) {
        setDestination(destination);
        return this;
    }

    public BusBooking price(double price) {
        setPrice(price);
        return this;
    }

    public BusBooking time(LocalTime time) {
        setTime(time);
        return this;
    }

    public BusBooking capacity(int capacity) {
        setCapacity(capacity);
        return this;
    }

    public BusBooking userId(Long userId) {
        setUserId(userId);
        return this;
    }

    public BusBooking busId(int busId) {
        setBusId(busId);
        return this;
    }

    public BusBooking user(user user) {
        setUser(user);
        return this;
    }

    public BusBooking bus(Bus bus) {
        setBus(bus);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BusBooking)) {
            return false;
        }
        BusBooking busBooking = (BusBooking) o;
        return id == busBooking.id && Objects.equals(source, busBooking.source) && Objects.equals(destination, busBooking.destination) && price == busBooking.price && Objects.equals(time, busBooking.time) && capacity == busBooking.capacity && Objects.equals(userId, busBooking.userId) && busId == busBooking.busId && Objects.equals(user, busBooking.user) && Objects.equals(bus, busBooking.bus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, source, destination, price, time, capacity, userId, busId, user, bus);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", source='" + getSource() + "'" +
            ", destination='" + getDestination() + "'" +
            ", price='" + getPrice() + "'" +
            ", time='" + getTime() + "'" +
            ", capacity='" + getCapacity() + "'" +
            ", userId='" + getUserId() + "'" +
            ", busId='" + getBusId() + "'" +
            ", user='" + getUser() + "'" +
            ", bus='" + getBus() + "'" +
            "}";
    }

}