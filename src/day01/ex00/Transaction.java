package day01.ex00;

import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User sender;
    private User recipient;
    private TransferCategory category;
    private Integer amount;

    public Transaction(User sender, User recipient, TransferCategory category, Integer amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.identifier = UUID.randomUUID();
        this.category = category;

        if (category == TransferCategory.OUTCOME) {
            if (amount > 0) {
                amount = 0;
            }
            this.amount = amount;
            amount *= -1;
            if ((sender.getBalance() - amount) > 0) {
                sender.outgoingTransfer(amount);
                recipient.incomingTransfer(amount);
            } else {
                System.out.println("Insufficient funds for a transaction");
            }
        }

        if (category == TransferCategory.INCOME) {
            if (amount < 0) {
                amount = 0;
            }
            this.amount = amount;
            if ((recipient.getBalance() - amount) > 0) {
                recipient.outgoingTransfer(amount);
                sender.incomingTransfer(amount);
            } else {
                System.out.println("Insufficient funds for a transaction");
            }
        }
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public TransferCategory getCategory() {
        return category;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction {" +
                "identifier = " + identifier +
                ", sender = " + sender +
                ", recipient = " + recipient +
                ", category = " + category +
                ", amount= " + amount +
                '}';
    }
}
