package lt.codeacademy.nd1;

import java.util.Scanner;

/**
 * Prompts user to enter his/her name and outputs it to console as per example below:<br><br>
 * Hello Dara!
 */
public class Task10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();

        System.out.println("Hello " + name + "!");

    }
}
