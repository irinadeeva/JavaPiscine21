package day01.ex03;

import day01.ex00.Transaction;
import java.util.UUID;
public interface TransactionsList {

    boolean addTransaction(Transaction transaction);
    boolean removeTransactionByID(UUID id) throws TransactionNotFoundException;
    Transaction[] toArray();
}
