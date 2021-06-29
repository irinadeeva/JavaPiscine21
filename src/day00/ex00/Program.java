package day00.ex00;

public class Program {
    public static void main(String[] args) {
        int CHAR_BIT = 8;
        final int SIZE_INT = 8;
        int number = 479598;
        int result = 0;
        int mask = number >> (SIZE_INT * CHAR_BIT - 1);
        number = (number + mask) ^ mask;


        result += number % 10;
        number = number / 10;
        result += number % 10;
        number = number / 10;
        result += number % 10;
        number = number / 10;
        result += number % 10;
        number = number / 10;
        result += number % 10;
        number = number / 10;
        result += number % 10;

        System.out.println(result);
    }
}
