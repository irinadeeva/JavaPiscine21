package day00.ex01;

import java.util.Scanner;


public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            boolean result = true;
            int i = 0;
            if (num < 2) {
                System.err.println("theIllegalArgument ");
                System.exit(-1);
            }
            else {
                for (i = 2; i < num / i; i++) {
                    if (num % i == 0) {
                        result = false;
                        break;
                    }
                }
                System.out.println(result + " " + (i - 1));
            }
        } else {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
    }
}