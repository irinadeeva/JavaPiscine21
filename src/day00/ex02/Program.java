package day00.ex02;

import java.util.Scanner;

public class Program {

    static int sumElement(int number){
        int result = 0;

        while(number != 0) {
            result += number % 10;
            number = number / 10;
        }
        return result;
    }

    static boolean primeNumber(int num){

        if (num == 1)
            return false;
        if (num > 3) {
            for (int i = 2; i <= num / i; ++i) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int coffeeCount = 0;
        Scanner sn = new Scanner(System.in);
        int i = sn.nextInt();

        while (i != 42) {
            if (primeNumber(sumElement(i)))
                coffeeCount ++;
            i = sn.nextInt();
        }
        System.out.println("Count of coffee-request - " + coffeeCount);
    }

}
