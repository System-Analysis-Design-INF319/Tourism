package com.example.demo.models;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Bus {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String source;
     private String destination;
     private double price;
     private LocalTime time;
     private int capacity;
     private int full;

     public Bus() {
     }

     public Bus(int id, String source, String destination, double price, LocalTime time, int capacity, int full) {
          this.id = id;
          this.source = source;
          this.destination = destination;
          this.price = price;
          this.time = time;
          this.capacity = capacity;
          this.full = full;
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

     public int getFull() {
          return this.full;
     }

     public void setFull(int full) {
          this.full = full;
     }

     public Bus id(int id) {
          setId(id);
          return this;
     }

     public Bus source(String source) {
          setSource(source);
          return this;
     }

     public Bus destination(String destination) {
          setDestination(destination);
          return this;
     }

     public Bus price(double price) {
          setPrice(price);
          return this;
     }

     public Bus time(LocalTime time) {
          setTime(time);
          return this;
     }

     public Bus capacity(int capacity) {
          setCapacity(capacity);
          return this;
     }

     public Bus full(int full) {
          setFull(full);
          return this;
     }

     @Override
     public boolean equals(Object o) {
          if (o == this)
               return true;
          if (!(o instanceof Bus)) {
               return false;
          }
          Bus bus = (Bus) o;
          return id == bus.id && Objects.equals(source, bus.source) && Objects.equals(destination, bus.destination)
                    && price == bus.price && Objects.equals(time, bus.time) && capacity == bus.capacity
                    && full == bus.full;
     }

     @Override
     public int hashCode() {
          return Objects.hash(id, source, destination, price, time, capacity, full);
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
                    ", full='" + getFull() + "'" +
                    "}";
     }

}