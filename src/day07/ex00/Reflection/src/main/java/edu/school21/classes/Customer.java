package edu.school21.classes;

import java.util.StringJoiner;

public class Customer {
    private String firstName;
    private String lastName;
    private int purchaseNumber;

    public Customer(Object name, Object surname, Object pN) {
        this.firstName = "Default first name";
        this.lastName = "Default last name";
        this.purchaseNumber = 0;
    }

    public Customer(String firstName, String lastName, int purchaseNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.purchaseNumber = purchaseNumber;
    }

    public int increaseTotalPurchase(int value) {
        this.purchaseNumber += value;
        return purchaseNumber;
    }

    public int returnPurchase(int value){
        this.purchaseNumber -= value;
        return purchaseNumber;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]").add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("purchaseNumber=" + purchaseNumber)
                .toString();
    }
}