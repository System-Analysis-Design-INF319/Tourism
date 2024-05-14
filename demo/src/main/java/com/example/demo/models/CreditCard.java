// package com.example.demo.models;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Transient;

// import java.util.Objects;

// @Entity
// public class CreditCard {
//      @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private String CardNumber;
//      private String Cvv;
//      private String ExpiryDate;
    


//     public CreditCard() {
//     }

//     public CreditCard(String CardNumber, String Cvv, String ExpiryDate) {
//         this.CardNumber = CardNumber;
//         this.Cvv = Cvv;
//         this.ExpiryDate = ExpiryDate;
//     }

//     public String getCardNumber() {
//         return this.CardNumber;
//     }

//     public void setCardNumber(String CardNumber) {
//         this.CardNumber = CardNumber;
//     }

//     public String getCvv() {
//         return this.Cvv;
//     }

//     public void setCvv(String Cvv) {
//         this.Cvv = Cvv;
//     }

//     public String getExpiryDate() {
//         return this.ExpiryDate;
//     }

//     public void setExpiryDate(String ExpiryDate) {
//         this.ExpiryDate = ExpiryDate;
//     }

//     public CreditCard CardNumber(String CardNumber) {
//         setCardNumber(CardNumber);
//         return this;
//     }

//     public CreditCard Cvv(String Cvv) {
//         setCvv(Cvv);
//         return this;
//     }

//     public CreditCard ExpiryDate(String ExpiryDate) {
//         setExpiryDate(ExpiryDate);
//         return this;
//     }

//     @Override
//     public boolean equals(Object o) {
//         if (o == this)
//             return true;
//         if (!(o instanceof CreditCard)) {
//             return false;
//         }
//         CreditCard creditCard = (CreditCard) o;
//         return CardNumber == creditCard.CardNumber && Cvv == creditCard.Cvv && ExpiryDate == creditCard.ExpiryDate;
//     }

//     @Override
//     public int hashCode() {
//         return Objects.hash(CardNumber, Cvv, ExpiryDate);
//     }

//     @Override
//     public String toString() {
//         return "{" +
//             " CardNumber='" + getCardNumber() + "'" +
//             ", Cvv='" + getCvv() + "'" +
//             ", ExpiryDate='" + getExpiryDate() + "'" +
//             "}";
//     }

//     public boolean isEmpty(String string) {
//         throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
//     }
    
// }

