package edu.school21.classes;

import java.util.StringJoiner;

public class Customer {
    private String firstName;
    private String lastName;
    private Integer purchaseNumber;

    public Customer() {
        this.firstName = "Default first name";
        this.lastName = "Default last name";
        this.purchaseNumber = 0;
    }

    public Customer(String firstName, String lastName, int purchaseNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.purchaseNumber = purchaseNumber;
    }

    public void increaseTotalPurchase(Integer value) {
        this.purchaseNumber += value;
    }

    public void returnPurchase(Integer value){
        this.purchaseNumber -= value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]").add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("purchaseNumber=" + purchaseNumber)
                .toString();
    }
}