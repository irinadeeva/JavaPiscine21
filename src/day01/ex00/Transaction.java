package day01.ex00;

import java.util.UUID;

/*enum {
    debits;
    credits}*/


public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private String transferCategory;
    private Integer transferAmount;
}
