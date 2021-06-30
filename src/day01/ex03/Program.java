package day01.ex03;

import java.util.UUID;

public class Program {
    public static void main(String[] args) throws TransactionNotFoundException {

        TransactionsLinkedList transactionsLinkedList = new TransactionsLinkedList();

        User user1 = new User("Alex", 95_000);
        User user2 = new User("Luka", 10_000);
        User user3 = new User("Adam", 150_000);
        User user4 = new User("Elen", -150_000);

        Transaction transaction1 = new Transaction(user1, user2, 10_000, UUID.randomUUID());
        Transaction transaction2 = new Transaction(user2, user1, 10_000, UUID.randomUUID());
        Transaction transaction3 = new Transaction(user4, user3, 5_000, UUID.randomUUID());
        Transaction transaction4 = new Transaction(user3, user4, 5_000, UUID.randomUUID());
        Transaction transaction5 = new Transaction(user3, user4, 5_000, UUID.randomUUID());
        Transaction transaction6 = new Transaction(user4, user3, 5_000, UUID.randomUUID());

        transactionsLinkedList.addTransaction(transaction1);
        transactionsLinkedList.addTransaction(transaction2);
        transactionsLinkedList.addTransaction(transaction3);
        transactionsLinkedList.addTransaction(transaction4);
        transactionsLinkedList.addTransaction(transaction5);
        transactionsLinkedList.addTransaction(transaction6);

        System.out.println("\n#--------------------------------------------#");
        System.out.println("Transactions to Array");
        System.out.println("#--------------------------------------------#\n");
        Transaction[] transactions = transactionsLinkedList.toArray();
        for (Transaction t : transactions) {
            System.out.println(t);
        }


        UUID uuid1 = transaction1.getIdentifier();
        UUID uuid3 = transaction3.getIdentifier();
        UUID uuid6 = transaction6.getIdentifier();

        transactionsLinkedList.removeTransactionByID(uuid1);
        transactionsLinkedList.removeTransactionByID(uuid3);
        transactionsLinkedList.removeTransactionByID(uuid6);

        System.out.println("\n#--------------------------------------------#");
        System.out.println("Transactions to Array after Removing ");
        System.out.println("#--------------------------------------------#\n");
        transactions = transactionsLinkedList.toArray();
        for (Transaction t : transactions) {
            System.out.println(t);
        }


        System.out.println("\n#--------------------------------------------#");
        System.out.println("Exception for non-existent transaction ");
        System.out.println("#--------------------------------------------#\n");
        transactionsLinkedList.removeTransactionByID(UUID.randomUUID());

    }
}
