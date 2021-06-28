package day00.ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        if (sn.hasNextInt()) {
            int num = sn.nextInt();

            if (num > 3) {
                boolean flag = true;
                int iteration = 0;

                for (int i = 2; i <= num / i; ++i) {
                    iteration++;
                    if (num % i == 0) {
                        flag = false;
                        break;
                    }
                }
                System.out.println(flag + " " + iteration);
            } else if (num == 2 || num == 3) {
                System.out.println(true + " " + 1);
            } else {
                System.err.println("Illegal Argument");
                System.exit(-1);
            }
        } else {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
    }
}
