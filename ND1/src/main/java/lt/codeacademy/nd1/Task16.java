package lt.codeacademy.nd1;

import java.util.Scanner;

/**
 * main metode paprašyti įvesti vartotjo skaičių ir jį priskirti String tekstas kintamajama.Pavesti į: int sk;<br>
 * > 5 - String sk = “5”; -> int ?
 */
public class Task16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Iveskit skaičių: ");
        String sk = sc.nextLine();

        System.out.println(sk + " - String sk = \"" + sk + "\"; -> int " + Integer.parseInt(sk));

    }
}
