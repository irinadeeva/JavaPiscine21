package day00.ex03;

import java.util.Scanner;

public class Program {

    static int searchMinWeekResult(Scanner sn) {
        int i = 0;

        int minWeekResult = sn.nextInt();
        while (i < 4) {
            if (minWeekResult < 1 || minWeekResult > 9) {
                System.err.println("Illegal Argument");
                System.exit(-1);
            }
            int weekResult = sn.nextInt();
            if (weekResult < minWeekResult) {
                minWeekResult = weekResult;
            }
            i++;
        }
        return minWeekResult;
    }


    static void printResult(long minResults) {
        long reverseMinResults = 0;
        int weekNumber = 0;
        int i = 1;

        while (minResults != 0) {
            reverseMinResults = reverseMinResults * 10 + minResults % 10;
            minResults = minResults / 10;
            weekNumber++;
        }

        while (i <= weekNumber) {
            System.out.print("Week ");
            System.out.print(i);
            System.out.print(" ");
            i++;
            long minWeekResult = reverseMinResults % 10;
            reverseMinResults = reverseMinResults / 10;
            while (minWeekResult != 0) {
                System.out.print(((char) 61));
                minWeekResult--;
            }
            System.out.println(">");
        }
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String line = sn.nextLine();
        int weekNumber = 1;
        long minResults = 0;

        while (!line.equals("42") && weekNumber < 19) {
            if (!line.equals("Week " + weekNumber)) {
                System.err.println("Illegal Argument");
                System.exit(-1);
            }
            minResults = minResults * 10 + searchMinWeekResult(sn);
            line = sn.nextLine();
            line = sn.nextLine();
            weekNumber++;
        }
        if (line.equals("Week 19")) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        printResult(minResults);
    }


}
