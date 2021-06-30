package day01.ex05;



import java.util.UUID;

public class TransactionsService {
    private UsersList usersList;

    public TransactionsService() {
        usersList = new UsersArrayList();
    }

    public void addUser(User user) {
        usersList.addUser(user);
    }

    public Integer getUserBalance(Integer id) throws UserNotFoundException {
        return usersList.getUserByID(id).getBalance();
    }

    public String getUserName(Integer id) throws UserNotFoundException {
        return usersList.getUserByID(id).getName();
    }

    public void performTransfer(Integer senderId, Integer recipientId, Integer amount) {
        User sender = usersList.getUserByID(senderId);
        User recipient = usersList.getUserByID(recipientId);

        if ((sender.getBalance() - amount) < 0)
            throw new IllegalTransactionException("The amount transfer exceeds " + sender.getName() + "’s balance");

        if (recipientId.equals(senderId))
            throw new IllegalTransactionException("Sender's and recipient's IDs are equal");

        UUID uuid = UUID.randomUUID();
        Transaction transactionOutcome = new Transaction(sender, recipient, -amount, uuid);
        Transaction transactionIncome = new Transaction(recipient, sender, amount, uuid);

        sender.setBalance(-amount);
        recipient.setBalance(amount);
        sender.getTransactions().addTransaction(transactionOutcome);
        recipient.getTransactions().addTransaction(transactionIncome);
    }

    public Transaction[] getUserTransaction(Integer userId) throws UserNotFoundException {
        return usersList.getUserByID(userId).getTransactions().toArray();
    }

    public boolean removeTransactionByIdForUser (Integer userId, UUID transactionId) throws TransactionNotFoundException, UserNotFoundException {
        return usersList.getUserByID(userId).getTransactions().removeTransactionByID(transactionId);
    }


    public Transaction[] findUnpairedTransactions (){
        TransactionsLinkedList unpaired = new TransactionsLinkedList();

        for (Integer i = 1; i <= usersList.getNumberOfUsers(); i++) {
            Transaction[] trArray = usersList.getUserByID(i).getTransactions().toArray();
            for (Transaction t : trArray) {
                Integer flag = 0;
                UUID uuid = t.getIdentifier();

                Transaction[] trRecipient = t.getRecipient().getTransactions().toArray();
                for (Transaction tR : trRecipient) {
                    if (tR.getIdentifier() == uuid) {
                        flag++;
                        break;
                    }
                }
                if (flag == 0)
                    unpaired.addTransaction(t);
            }
        }
        return unpaired.toArray();
    }
}
