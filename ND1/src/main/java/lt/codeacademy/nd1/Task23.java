package lt.codeacademy.nd1;

import java.util.Scanner;

/**
 * Write a program that asks a user to choose between four colours: black, white, red, or blue.
 * Use switch to display one of the following messages, depending on which
 * colour was chosen:<br>
 * <ol type='a'>
 *     <li>BLACK "You must be a Goth!"</li>
 *     <li>WHITE "You are a very pure person"</li>
 *     <li>RED "You are fun and outgoing"</li>
 *     <li>BLUE "You're not a Chelsea fan, are you?"</li>
 * </ol>
 */
public class Task23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter color (black, white, red or blue): ");
        String color = sc.nextLine();

        switch (color.toUpperCase()) {
            case "BLACK":
                System.out.println("You must be a Goth!");
                break;
            case "WHITE":
                System.out.println("You are a very pure person");
                break;
            case "RED":
                System.out.println("You are fun and outgoing");
                break;
            case "BLUE":
                System.out.println("You're not a Chelsea fan, are you?");
                break;
            default:
                System.out.println("Invalid color: " + color);
        }

    }
}







