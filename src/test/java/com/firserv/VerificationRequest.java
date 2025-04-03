package com.firserv;

public class VerificationRequest {

    private String cardNumber;




    // Constructor for cardNumber
    public VerificationRequest(String cardNumber) {
        this.cardNumber = cardNumber;
    }


//    Getters and Setters

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }




}