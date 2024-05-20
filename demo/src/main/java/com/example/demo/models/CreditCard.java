package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class CreditCard {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String CardName;
      private String CardNumber;
      private String Cvv;
      private LocalDate ExpiryDate;

    public CreditCard() {
    }
   
    public CreditCard(String CardName, String CardNumber, String Cvv, LocalDate ExpiryDate) {
        this.CardName = CardName;
        this.CardNumber = CardNumber;
        this.Cvv = Cvv;
        this.ExpiryDate = ExpiryDate;
    }

    public String getCardName() {
        return this.CardName;
    }

    public void setCardName(String CardName) {
        this.CardName = CardName;
    }

    public String getCardNumber() {
        return this.CardNumber;
    }

    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }

    public String getCvv() {
        return this.Cvv;
    }

    public void setCvv(String Cvv) {
        this.Cvv = Cvv;
    }

    public LocalDate getExpiryDate() {
        return this.ExpiryDate;
    }

    public void setExpiryDate(LocalDate ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    public CreditCard CardName(String CardName) {
        setCardName(CardName);
        return this;
    }

    public CreditCard CardNumber(String CardNumber) {
        setCardNumber(CardNumber);
        return this;
    }

    public CreditCard Cvv(String Cvv) {
        setCvv(Cvv);
        return this;
    }

    public CreditCard ExpiryDate(LocalDate ExpiryDate) {
        setExpiryDate(ExpiryDate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreditCard)) {
            return false;
        }
        CreditCard creditCard = (CreditCard) o;
        return Objects.equals(CardName, creditCard.CardName) && Objects.equals(CardNumber, creditCard.CardNumber) && Objects.equals(Cvv, creditCard.Cvv) && Objects.equals(ExpiryDate, creditCard.ExpiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CardName, CardNumber, Cvv, ExpiryDate);
    }

    @Override
    public String toString() {
        return "{" +
            " CardName='" + getCardName() + "'" +
            ", CardNumber='" + getCardNumber() + "'" +
            ", Cvv='" + getCvv() + "'" +
            ", ExpiryDate='" + getExpiryDate() + "'" +
            "}";
    }

    


    

    public boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public boolean isValidDate(LocalDate ExpiryDate) {
        LocalDate currentDate = LocalDate.now();
        return currentDate.isBefore(ExpiryDate);
    }

    
    
    
}

