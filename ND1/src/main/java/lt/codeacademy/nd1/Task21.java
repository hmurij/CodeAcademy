package lt.codeacademy.nd1;

import java.util.Scanner;

/**
 * Write a program that accepts user input from the console. The program should take a number
 * and then test for the following age ranges: 0 to 10, 11 to 20, 21 to 30, 30 and over.
 * Display a message in the Output window in the following format: user_age + " is between 21 and 30"
 */
public class Task21 {
    public static void main(String[] args) {

//        int age = new Random().nextInt(150);
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter age in range from 1 to 150: ");
        int age = sc.nextInt();
        
        for (int i = 10; i <= 150; i += 10) {
            if (i - 9 <= age && age <= i) {
                System.out.println(age + " is between " + (i - 9) + " and " + i);
                break;
            }
        }

    }
}
