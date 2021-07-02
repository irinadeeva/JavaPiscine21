/*
package day03.ex01;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Program {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("NB! The flag with a number of times is not passed");
            System.exit(0);
        }
        if (!args[0].startsWith("--count=")) {
            System.out.println("NB! The flag is wrong. The right flag is --count=NUMBER");
            System.exit(0);
        }

        int count = 0;
        try {
            count = Integer.parseInt(args[0].substring(args[0].indexOf("=") + 1));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }



    }
}
*/
