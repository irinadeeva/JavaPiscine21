package day01.ex05;

import java.util.Scanner;
import java.util.UUID;

public class Menu {
    TransactionsService service;

    public Menu() {
        this.service = new TransactionsService();
    }

    public void operation(Integer command, Scanner scanner) {
        if (command.equals(1)) {
            System.out.println("Enter a user name and a balance");
            String[] nameBalance = scanner.nextLine().split(" ");
            if (nameBalance.length != 2) {
                nameBalance = correctNameNumber(scanner, 2, "Please, enter two args: an user name and a balance\"");
            }
            Integer balance = correctNumber(scanner, nameBalance[1], "Please, enter a balance as a number");
            User user = new User(nameBalance[0], balance);
            service.addUser(user);
            System.out.println("User with id = " + user.getIdentifier() + " is added");
            System.out.println("---------------------------------------------------------");
        }
        if (command.equals(2)) {
            System.out.println("Enter a user ID");
            String line = scanner.nextLine();
            Integer id = correctNumber(scanner, line, "Please, enter an ID as a number");

            System.out.println(service.getUserName(id) + " - " + service.getUserBalance(id));
            System.out.println("---------------------------------------------------------");
        }
        if (command.equals(3)) {
            System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
            String[] line = scanner.nextLine().split(" ");

            if (line.length != 3) {
                line = correctNameNumber(scanner, 3, "please, enter a sender ID, a recipient ID, and a transfer amount");
            }

            Integer senderId = correctNumber(scanner, line[0], "Please, enter a sender ID as a number");
            Integer recipientId = correctNumber(scanner, line[1], "Please, enter a recipient ID as a number");
            Integer amount = correctNumber(scanner, line[2], "Please, enter a transfer amount as a number");
            service.performTransfer(senderId, recipientId, amount);
            System.out.println("The transfer is completed");
            System.out.println("---------------------------------------------------------");
        }
        if (command.equals(4)) {
            System.out.println("Enter a user ID");
            String line = scanner.nextLine();
            Integer id = correctNumber(scanner, line, "Please, enter an ID as a number");

            Transaction[] transactions = service.getUserTransaction(id);

            for (Transaction t : transactions){
                String frag = "From ";
                if (t.getAmount() < 0)
                    frag = "To ";
                System.out.println(frag + t.getRecipient().getName() +"(id = " + t.getRecipient().getIdentifier() +") " + t.getAmount() +" with id = " + t.getIdentifier());
            }
            System.out.println("---------------------------------------------------------");
        }
        if(command.equals(5)){
            System.out.println("Enter a user ID and a transfer ID");
            String[] line = scanner.nextLine().split(" ");

            if (line.length != 2) {
                line = correctNameNumber(scanner, 2, "please, enter a user ID and a transfer ID");
            }
            Integer userId = correctNumber(scanner, line[0], "Please, enter an ID as a number");
            UUID transferId = UUID.fromString(line[1]);

            Transaction[] transactions = service.getUserTransaction(userId);
            Transaction print = null;
            for (Transaction t : transactions){
                if (t.getIdentifier().equals(transferId))
                    print = t;
            }

            service.removeTransactionByIdForUser(userId, transferId);
            if (print != null)
                System.out.println("Transfer To " + print.getRecipient().getName() + "(id = " +
                    print.getRecipient().getIdentifier() + ") " + print.getAmount() + " removed");
            System.out.println("---------------------------------------------------------");

        }
        if(command.equals(6)){
            System.out.println("Check results:");
            Transaction[] transactions =  service.findUnpairedTransactions();
            if (transactions.length == 0)
                System.out.println("No unpaired transaction");
            for (Transaction t : transactions){
                System.out.println(t.getSender().getName() + "(id = " + t.getSender().getIdentifier() +
                        ") has an unacknowledged transfer id = " + t.getIdentifier() + "from " +
                        t.getRecipient().getName() + "(id = " + t.getRecipient().getIdentifier() + ") for " + t.getAmount());
            }
            System.out.println("---------------------------------------------------------");
        }
    }

    public void printMenuForDev() {
        System.out.println("1. Add a user\n" +
                "2. View user balances\n" +
                "3. Perform a transfer\n" +
                "4. View all transactions for a specific user\n" +
                "5. DEV - remove a transfer by ID \n" +
                "6. DEV - check transfer validity\n" +
                "7. Finish execution");
    }

    public void printMenuForProd() {
        System.out.println("1. Add a user\n" +
                "2. View user balances\n" +
                "3. Perform a transfer\n" +
                "4. View all transactions for a specific user\n" +
                "5. Finish execution");
    }

    private String[] correctNameNumber(Scanner scanner, Integer length, String message) {
        while (true) {
            System.out.println(message);
            String[] nameBalance = scanner.nextLine().split(" ");
            if (nameBalance.length == length) {
                return nameBalance;
            }
        }
    }

    private Integer correctNumber(Scanner scanner, String balance, String message) {
        while (true) {
            for (int i = 0; i < balance.length(); i++) {
                if (balance.charAt(i) < 48 || balance.charAt(i) > 57) {
                    System.out.println(message);
                    balance = scanner.nextLine();
                    i = 0;
                }
            }
            return Integer.valueOf(balance);
        }
    }


}
