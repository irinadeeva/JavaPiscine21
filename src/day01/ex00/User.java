package day01.ex00;

import java.util.UUID;

public class User {
    private UUID identifier;
    private String name;
    private Integer balance;

    public User(String name, Integer balance) {
        this.name = name;
        this.balance = balance;

    }


}
