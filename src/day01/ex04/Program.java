package day01.ex04;

import java.util.UUID;

public class Program {
    public static void main(String[] args) throws IllegalTransactionException {
        TransactionsService service = new TransactionsService();

        User user1 = new User("Alex", 95_000);
        User user2 = new User("Luka", 10_000);
        User user3 = new User("Adam", 150_000);
        User user4 = new User("Elen", -150_000);

        service.addUser(user1);
        service.addUser(user2);
        service.addUser(user3);
        service.addUser(user4);

        System.out.println("\n#--------------------------------------------#");
        System.out.println("Users' balance");
        System.out.println("#--------------------------------------------#\n");
        System.out.println("User 1 has a balance equal to " + service.getUserBalance(user1.getIdentifier()));
        System.out.println("User 2 has a balance equal to " + service.getUserBalance(user2.getIdentifier()));
        System.out.println("User 3 has a balance equal to " + service.getUserBalance(user3.getIdentifier()));
        System.out.println("User 4 has a balance equal to " + service.getUserBalance(user4.getIdentifier()));

        service.performTransfer(user1.getIdentifier(), user2.getIdentifier(), 5000);
        service.performTransfer(user3.getIdentifier(), user4.getIdentifier(), 50000);

        System.out.println("\n#--------------------------------------------#");
        System.out.println("Users' balance after a few transfers");
        System.out.println("#--------------------------------------------#\n");
        System.out.println("User 1 has a balance equal to " + service.getUserBalance(user1.getIdentifier()));
        System.out.println("User 2 has a balance equal to " + service.getUserBalance(user2.getIdentifier()));
        System.out.println("User 3 has a balance equal to " + service.getUserBalance(user3.getIdentifier()));
        System.out.println("User 4 has a balance equal to " + service.getUserBalance(user4.getIdentifier()));

        System.out.println("\n#--------------------------------------------#");
        System.out.println("User's transactions");
        System.out.println("#--------------------------------------------#\n");
        Transaction[] userTransactions = service.getUserTransaction(user2.getIdentifier());
        for (Transaction t : userTransactions) {
            System.out.println(t);
        }

        System.out.println("\n#--------------------------------------------#");
        System.out.println("List of unpaired transactions");
        System.out.println("#--------------------------------------------#\n");
        Transaction[] unpairedTransactions = service.findUnpairedTransactions();
        if (unpairedTransactions.length == 0)
            System.out.println("No unpaired transaction");
        for (Transaction t : unpairedTransactions) {
            System.out.println(t);
        }

        System.out.println("\n#--------------------------------------------#");
        System.out.println("List of unpaired transactions");
        System.out.println("#--------------------------------------------#\n");

        Transaction[] userTransactions2 = service.getUserTransaction(user4.getIdentifier());
        UUID uuid = UUID.randomUUID();
        if (userTransactions2.length != 0)
            uuid = userTransactions2[0].getIdentifier();
        service.removeTransactionByIdForUser(user4.getIdentifier(), uuid);

        Transaction[] unpairedTransactions2 = service.findUnpairedTransactions();
        for (Transaction t : unpairedTransactions2) {
            System.out.println(t);
        }

        /*System.out.println("\n#--------------------------------------------#");
        System.out.println("Exception demo");
        System.out.println("#--------------------------------------------#\n");
        service.performTransfer(user3.getIdentifier(), user4.getIdentifier(), 5000000);*/
    }
}
