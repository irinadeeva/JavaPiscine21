package day01.ex05;

import java.util.UUID;

public interface TransactionsList {

    boolean addTransaction(Transaction transaction);

    boolean removeTransactionByID(UUID id) throws TransactionNotFoundException;

    Transaction[] toArray();
}
