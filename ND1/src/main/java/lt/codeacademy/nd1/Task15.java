package lt.codeacademy.nd1;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Write a Java program to convert minutes into a number of years and days
 */
public class Task15 {
    public static void main(String[] args) {

        IntStream.rangeClosed(1, 10).map(i -> new Random().nextInt(Integer.MAX_VALUE / 4)).forEach(i -> {
            String format = "%17s%d\n";
            System.out.printf(format, "Minutes: ", i);
            System.out.printf(format, "Number of days: ", convertMinutesToDays(i));
            System.out.printf(format + "\n", "Number of years: ", covertMinutesToYears(i));
        });

    }

    /**
     * Converts minutes to number of years
     *
     * @param i any arbitrary number in range from 0 to 2147483647
     * @return minutes converted to number of years
     */
    private static int covertMinutesToYears(int i) {
        return convertMinutesToDays(i) / 365;
    }

    /**
     * Converts minutes to number of days
     *
     * @param i any arbitrary number in range from 0 to 2147483647
     * @return minutes converted to number of days
     */
    private static int convertMinutesToDays(int i) {
        return i / (60 * 24);
    }


}

