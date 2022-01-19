package lt.codeacademy.nd1;

import java.util.Random;
import java.util.stream.IntStream;

import static lt.codeacademy.nd1.OddTest.isOdd;

/**
 * Write a boolean method called isOdd() in a class called OddTest,
 * which takes an int as input and returns true if the it is odd.
 */
public class Task11 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).map(i -> 50 - new Random().nextInt(100))
                .forEach(i -> System.out.printf("%3d - %s\n", i, isOdd(i)));
    }
}

class OddTest {

    /**
     * Takes int as parameter and returns true if it is odd and false otherwise
     *
     * @param input any arbitrary number in range from -2147483648 to 2147483647
     * @return true if input is odd and false otherwise
     */
    public static boolean isOdd(int input) {
        return input % 2 == 0;
    }
}
