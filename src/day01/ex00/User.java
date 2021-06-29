package day01.ex00;

public class User {
    private int identifier;
    private String name;
    private Integer balance;
    private static Integer counter = 0;


    public User(String name, Integer balance) {
        this.name = name;
        nextId();
        setBalance(balance);

    }

    private Integer nextId() {
        return this.identifier = counter++;
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
