package day01.ex03;

import day01.ex00.Transaction;
import day01.ex00.TransferCategory;
import day01.ex00.User;

import java.util.UUID;

public class Program {
    public static void main(String[] args) throws TransactionNotFoundException{
        TransactionsLinkedList transactionsLinkedList = new TransactionsLinkedList();

        day01.ex00.User user1 = new day01.ex00.User("Alex", 95_000);
        day01.ex00.User user2 = new day01.ex00.User("Luka", 10_000);
        day01.ex00.User user3 = new day01.ex00.User("Adam", 150_000);
        day01.ex00.User user4 = new User("Elen", -150_000);

        Transaction transaction1 = new Transaction(user1, user2, TransferCategory.OUTCOME, -10_000);
        Transaction transaction2 = new Transaction(user2, user1, TransferCategory.INCOME, 10_000);
        Transaction transaction3 = new Transaction(user4, user3, TransferCategory.OUTCOME, -5_000);
        Transaction transaction4 = new Transaction(user3, user4, TransferCategory.INCOME, 5_000);
        Transaction transaction5 = new Transaction(user3, user4, TransferCategory.OUTCOME, -5_000);
        Transaction transaction6 = new Transaction(user4, user3, TransferCategory.INCOME, 5_000);

        transactionsLinkedList.addTransaction(transaction1);
        transactionsLinkedList.addTransaction(transaction2);
        transactionsLinkedList.addTransaction(transaction3);
        transactionsLinkedList.addTransaction(transaction4);
        transactionsLinkedList.addTransaction(transaction5);
        transactionsLinkedList.addTransaction(transaction6);


        Transaction[] transactions = transactionsLinkedList.toArray();
        for (Transaction t: transactions) {
            System.out.println(t);
        }
        System.out.println("#--------------------------------------------#");


        UUID uuid1 = transaction1.getIdentifier();
        UUID uuid3 = transaction3.getIdentifier();
        UUID uuid6 = transaction6.getIdentifier();

        transactionsLinkedList.removeTransactionByID(uuid1);
        transactionsLinkedList.removeTransactionByID(uuid3);
        transactionsLinkedList.removeTransactionByID(uuid6);

        transactions = transactionsLinkedList.toArray();
        for (Transaction t: transactions) {
            System.out.println(t);
        }

    }
}
