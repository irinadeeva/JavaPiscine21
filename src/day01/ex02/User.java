package day01.ex02;

import day01.ex01.UserIdsGenerator;

public class User {
    private Integer identifier;
    private String name;
    private Integer balance;

    public User(String name, Integer balance) {
        this.identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        setBalance(balance);
    }

    private void setBalance(Integer balance) {
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public void outgoingTransfer(Integer amount) {
        this.balance -= amount;
    }

    public void incomingTransfer(Integer amount) {
        this.balance += amount;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User {" +
                "identifier = " + identifier +
                ", name = '" + name + '\'' +
                ", balance = " + balance +
                '}';
    }
}


