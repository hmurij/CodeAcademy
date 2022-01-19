package lt.codeacademy.nd1;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Write a method called arrayToString(), which takes an int array and return a String in the form of
 * {a1, a2, ..., an}. Take note that there is no comma after the last element.
 */
public class Task12 {
    public static void main(String[] args) {
        Random r = new Random();
        IntStream.rangeClosed(1 , 10).mapToObj(i -> r.ints(r.nextInt(10) + 5, 0, 10)
                        .toArray()).peek(a -> System.out.println(Arrays.toString(a)))
                .map(Task12::arrayToString).forEach(System.out::println);

    }

    /**
     * Takes array of type int as parameter and returns string
     * representation of array in format {a1, a2, ..., an}.
     * @param array arbitrary array of int type elements
     * @return String type representation of an array in {a1, a2, ..., an} format.
     */
    public static String arrayToString(int[] array) {
        return "{" + Arrays.stream(array).mapToObj(Integer::toString).collect(Collectors.joining(", ")) + "}";
    }
}
