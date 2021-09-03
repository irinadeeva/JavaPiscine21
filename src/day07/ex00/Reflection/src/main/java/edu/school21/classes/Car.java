package edu.school21.classes;

public class Car {
    private String brand;
    private Integer price;
    private String color;
    private Integer speed;

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

    public void increaseSpeed(Integer increment) {
        this.speed  =+ increment;
    }

    public void decreaseSpeed(Integer increment) {
        this.speed =- increment;
    }

    public String repaintCar(String color){
        this.color = color;
        return color;
    }

    public void decreasePrice(Integer increment){
        this.price =- increment;
    }

    public void increasePrice(Integer increment){
        this.price =+ increment;
    }

    @Override
    public String toString() {
        return "Car {" +
                "brand = '" + brand + '\'' +
                ", price = " + price +
                ", color = '" + color + '\'' +
                ", speed = " + speed +
                '}';
    }
}
