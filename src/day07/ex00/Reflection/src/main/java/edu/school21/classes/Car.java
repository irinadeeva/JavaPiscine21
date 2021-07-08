package edu.school21.classes;

public class Car {
    private String brand;
    private int price;
    private String color;
    private int speed;

    public Car() {
        this.brand = "Default brand";
        this.price = 0;
        this.color = "Default color";
        this.speed = 0;
    }

    public Car(String b, int price, String color, int speed) {
        this.brand = b;
        this.price = price;
        this.color = color;
        this.speed = speed;
    }

    public int increaseSpeed(int increment) {
        this.speed  =+ increment;
        return this.speed;
    }

    public int decreaseSpeed(int increment) {
        this.speed =- increment;
        return this.speed;
    }

    public String repaintCar(String color){
        this.color = color;
        return color;
    }

    public int decreasePrice(int increment){
        this.price =- increment;
        return this.price;
    }

    public int increasePrice(int increment){
        this.price =+ increment;
        return this.price;
    }

    @Override
    public String toString() {
        return "Car {" +
                "brand = '" + brand + '\'' +
                ", priceModel = " + price +
                ", color = '" + color + '\'' +
                ", speed = " + speed +
                '}';
    }
}
