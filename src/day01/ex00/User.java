package day01.ex00;

import java.util.UUID;

public class User {
    private Integer identifier;
    private String name;
    private Integer balance;
    private static Integer counter = 0;


    public User(String name, Integer balance) {
        this.name = name;
        nextId();
        setBalance(balance);

    }

    public String getName() {
        return name;
    }

    private long nextId(){
        return this.identifier = counter++;
    }

    private void setBalance(Integer balance) {
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public Integer getBalance() {
        return balance;
    }

    public void outgoingTransfer(Integer amount){
        this.balance -= amount;
    }

    public void incomingTransfer(Integer amount){
        this.balance += amount;
    }


    @Override
    public String toString() {
        return "User{" +
                "identifier=" + identifier +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
