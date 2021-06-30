package day01.ex00;

import java.util.UUID;

public class User {
    private Integer identifier;
    private String name;
    private Integer balance;


    public User(String name, Integer balance) {
        this.name = name;
        Integer id = UUID.randomUUID().hashCode();
        if (id < 0)
            id = -id;
        this.identifier = id;
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getIdentifier() {
        return identifier;
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
