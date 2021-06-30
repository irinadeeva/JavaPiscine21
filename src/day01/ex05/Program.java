package day01.ex05;

import java.util.Scanner;

public class Program {

    static Integer parseInputDev(String input, Scanner scanner) {
        while (true) {
            if (input.equals("1"))
                return 1;
            if (input.equals("2"))
                return 2;
            if (input.equals("3"))
                return 3;
            if (input.equals("4"))
                return 4;
            if (input.equals("5"))
                return 5;
            if (input.equals("6"))
                return 6;
            if (input.equals("7"))
                return 7;
            System.out.println("Please, enter from 1 to 7 :");
            input = scanner.nextLine();
            parseInputDev(input, scanner);
        }
    }

    static Integer parseInput(String input, Scanner scanner) {
        while (true) {
            if (input.equals("1"))
                return 1;
            if (input.equals("2"))
                return 2;
            if (input.equals("3"))
                return 3;
            if (input.equals("4"))
                return 4;
            if (input.equals("5"))
                return 5;
            System.out.println("Please, enter from 1 to 5 :");
            input = scanner.nextLine();
            parseInput(input, scanner);
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Menu menu = new Menu();

            if (args.length != 0 && args[0].equals("--profile=dev")) {
                menu.printMenuForDev();
                String input = scanner.nextLine();
                Integer parsedInput = parseInputDev(input, scanner);
                while (!parsedInput.equals(7)) {
                    menu.operation(parsedInput, scanner);
                    menu.printMenuForDev();
                    input = scanner.nextLine();
                    parsedInput = parseInputDev(input, scanner);
                }
            } else {
                menu.printMenuForProd();
                String input = scanner.nextLine();
                Integer parsedInput = parseInput(input, scanner);
                while (!parsedInput.equals(5)) {
                    menu.operation(parsedInput, scanner);
                    menu.printMenuForProd();
                    input = scanner.nextLine();
                    parsedInput = parseInput(input, scanner);

                }
            }
        } catch (UserNotFoundException | TransactionNotFoundException |
                IllegalTransactionException e) {
            e.printStackTrace();
        }
    }
}
