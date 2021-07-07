package edu.school21.numbers;

class IllegalNumberException extends RuntimeException {
    public IllegalNumberException() {
        super("Number is less than 2");
    }
}


public class NumberWorker {

    public boolean isPrime(int number) {
        if (number < 2) {
            throw new IllegalNumberException();
        } else {
            for (int i = 2; i <= number / i; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int digitsSum(int number) {
        int result = 0;

        while (number != 0) {
            result += number % 10;
            number = number / 10;
        }
        return result;
    }


}
