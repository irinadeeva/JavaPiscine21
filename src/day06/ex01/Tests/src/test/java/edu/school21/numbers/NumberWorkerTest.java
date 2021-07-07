package edu.school21.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberWorkerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53,
            59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131,
            137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199})
    void isPrimeForPrimes(int number) {
        assertTrue(new NumberWorker().isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25,
            26, 27, 28, 30, 32, 33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46,
            48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 60, 62, 63, 64})
    void isPrimeForNotPrimes(int number) {
        assertFalse(new NumberWorker().isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -8, -9, -10, -12, -14, -15, -16, -18, -20, -21, -22, -24, -25,
            -59, -61, -67, -71, -73, -79, -83, -89, -97, -101, -103, -107, -109, -113, -127, -131})
    void isPrimeForIncorrectNumbers(int number) {
        Exception exception = assertThrows(RuntimeException.class, () ->
                new NumberWorker().isPrime(number));

        String expectedMessage = "Number is less than 2";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void digitsSumTrue(int input, int expected) {

        int actualValue = new NumberWorker().digitsSum(input);
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_fails.csv", numLinesToSkip = 1)
    void digitsSumFalse(int input, int expected) {

        int actualValue = new NumberWorker().digitsSum(input);
        assertNotEquals(expected, actualValue);
    }
}