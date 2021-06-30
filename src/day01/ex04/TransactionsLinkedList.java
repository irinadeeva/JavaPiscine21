package day01.ex04;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private Integer size;
    private Node first;
    private Node last;

    public TransactionsLinkedList() {
        this.size = 0;
    }

    private static class Node {
        Transaction transaction;
        Node next;
        Node prev;

        Node(Transaction transaction) {
            this.transaction = transaction;
        }
    }

    @Override
    public boolean addTransaction(Transaction transaction) {
        final Node l = last;
        final Node newNode = new Node(transaction);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
            newNode.prev = l;
        }
        size++;
        return true;
    }

    @Override
    public boolean removeTransactionByID(UUID id) throws TransactionNotFoundException {
        for (Node x = first; x != null; x = x.next) {
            if (id.equals(x.transaction.getIdentifier())) {
                final Node next = x.next;
                final Node prev = x.prev;

                if (prev == null) {
                    first = next;
                } else {
                    prev.next = next;
                    x.prev = null;
                }

                if (next == null) {
                    last = prev;
                } else {
                    next.prev = prev;
                    x.next = null;
                }

                x.transaction = null;
                size--;
                return true;
            }
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] result = new Transaction[size];
        int i = 0;
        for (Node x = first; x != null; x = x.next)
            result[i++] = x.transaction;
        return result;
    }


}
