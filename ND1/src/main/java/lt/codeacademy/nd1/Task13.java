package lt.codeacademy.nd1;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lt.codeacademy.nd1.PhoneKeyPad.processInput;

/**
 * On your phone keypad, the alphabets are mapped to digits as follows:
 * ABC(2), DEF(3), GHI(4), JKL(5), MNO(6), PQRS(7), TUV(8), WXYZ(9).
 * Write a program called PhoneKeyPad, which prompts user for a String (case insensitive),
 * and converts to a sequence of keypad digits. Use a nested-if (or switch-case) in this exercise.
 * <p>
 * Ex: 22,2,22,2 -> (BABA)
 */
public class Task13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter keypad sequence (ex. 22,2,22,2):");
        System.out.println(processInput(sc.nextLine()));

//        testProccessInput(10);

    }

    /**
     * Generates random input data and runs processInput n times
     * @param count number of test cycles
     */
    private static void testProccessInput(int count) {
        for(int i = 0; i < count; i++) {
            String input = generateTestData();
            System.out.println(input);
            System.out.println(processInput(input));
        }
    }

    /**
     * Generates random test data
     *
     * @return random String in format 3,44,3,222,77,88,55,99,4
     */
    private static String generateTestData() {
        // generate random test data
        Random r = new Random();
        String input = IntStream.range(1, 10).mapToObj(i -> {
                    int number = r.nextInt(8) + 2;
                    int size = number == 7 || number == 9 ? 4 : 3;
                    return r.ints(r.nextInt(size) + 1, number, number + 1).toArray();
                })
                .map(a -> Arrays.stream(a).mapToObj(Integer::toString)
                        .collect(Collectors.joining(""))).collect(Collectors.joining(","));
        return input;
    }
}

class PhoneKeyPad {


    /**
     * Processes user input based on mapped digits as per below:<br>
     * ABC(2), DEF(3), GHI(4), JKL(5), MNO(6), PQRS(7), TUV(8), WXYZ(9).
     * <p>Converts input to a sequence of letters corresponding to keypad digits.
     *
     * @param input String object user input in format 3,44,3,222,77,88,55,99,4 representing key pad input
     * @return converted user input in BABBC format
     */
    public static String processInput(String input) {
        String[] inputs = input.split(",");

        StringBuffer output = new StringBuffer();
        for (String in : inputs) {
            switch (in.charAt(0)) {
                case '2':
                    output.append("ABC".charAt(in.length() - 1));
                    break;
                case '3':
                    output.append("DEF".charAt(in.length() - 1));
                    break;
                case '4':
                    output.append("GHI".charAt(in.length() - 1));
                    break;
                case '5':
                    output.append("JKL".charAt(in.length() - 1));
                    break;
                case '6':
                    output.append("MNO".charAt(in.length() - 1));
                    break;
                case '7':
                    output.append("PQRS".charAt(in.length() - 1));
                    break;
                case '8':
                    output.append("TUV".charAt(in.length() - 1));
                    break;
                case '9':
                    output.append("WXYZ".charAt(in.length() - 1));
                    break;

            }
        }

        return output.toString();
    }

}






















