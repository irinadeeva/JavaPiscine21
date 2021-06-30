package day01.ex04;


import java.util.UUID;

enum TransferCategory {
    OUTCOME,
    INCOME
}

public class Transaction {
    private UUID identifier;
    private User sender;
    private User recipient;
    private TransferCategory category;
    private Integer amount;

    public Transaction(User sender, User recipient, Integer amount, UUID identifier) {
        this.identifier = identifier;
        this.sender = sender;
        this.recipient = recipient;
        if (amount < 0)
            this.category = TransferCategory.OUTCOME;
        else
            this.category = TransferCategory.INCOME;
        this.amount = amount;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "Transaction {" +
                "identifier = " + identifier +
                ", sender = " + sender +
                ", recipient = " + recipient +
                ", category = " + category +
                ", amount = " + amount +
                '}';
    }
}