package day01.ex00;

import java.util.UUID;

enum TransferCatagory{
    OUTCOME,
    INCOME;
}

public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private TransferCatagory category;
    private Integer amount;

    public Transaction(User recipient, User sender, TransferCatagory category, Integer amount) {
        this.identifier = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        this.category = category;

        if (category == TransferCatagory.OUTCOME){
            if (amount < 0){
                
            }
        }

        /*if (amount > 0)
            this.amount = amount;
        else
            amount = 0;

        if ((sender.getBalance() - amount) > 0){
                sender.outgoingTransfer(amount);
                recipient.incomingTransfer(amount);
            }else {
                System.out.println("Insufficient funds for the transaction");
            }
*/

    }


}
