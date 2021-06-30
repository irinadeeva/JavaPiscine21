package day01.ex05;

public class User {
    private Integer identifier;
    private String name;
    private Integer balance;
    private TransactionsList transactions;

    public User(String name, Integer balance) {
        this.identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
        transactions = new TransactionsLinkedList();
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

    public void setBalance(Integer balance) {
        this.balance += balance;
    }

    public TransactionsList getTransactions() {
        return transactions;
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