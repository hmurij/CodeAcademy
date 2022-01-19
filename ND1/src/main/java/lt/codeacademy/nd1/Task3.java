package lt.codeacademy.nd1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Task3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Summa: " + IntStream.rangeClosed(1, 5).map(i -> {
            System.out.println("Iveskit sveiką skaičių Nr" + i + ": ");
            return s.nextInt();
        }).sum()); // ;-)

        s.close();
    }
}
