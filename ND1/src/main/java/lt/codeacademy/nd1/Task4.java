package lt.codeacademy.nd1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Iveskit tekstą:");
        String text = sc.nextLine();
        // test sample text
//        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
//        System.out.println(text);

        // a.panaudojant įvestą teksto reikšmę išspausdinti:
        // i.viską didžiosiomis raidėmis
        System.out.println("\nViskas didžiosiomis raidėmis");
        System.out.println(text.toUpperCase() + "\n");

        // ii.išvesti įvesto teksto ilgį
        System.out.println("Ivesto teksto ilgis = " + text.length());

        // iii.išspausdinti įvesto teksto paskutinį žodį (panaudoti: lastIndexOf)
        String[] words = text.split(" ");
//        System.out.println(Arrays.toString(words));
        System.out.println("\nTeksto paskutinis žodis: " + text.substring(text.lastIndexOf(words[words.length - 1])));

        // iv.visas raides 'a' pakeitus į 'W'
        System.out.println("\nVisas raides 'a' pakeitus į 'W'");
        System.out.println(text.replace("a", "W"));

        // v. visas raides 'e' pakeitus į 'RAIDE'
        System.out.println("\nVisas raides e pakeitus į RAIDE");
        System.out.println(text.replace("e", "RAIDE"));

        // vi.sukeisti pirmą sakinio žodį su paskutiniu sakinio žodžiu
        System.out.println("\nSukeitus pirmą sakinio žodį su paskutiniu sakinio žodžiu");
        System.out.println(words[words.length - 1] + text.substring(words[0].length(), text.lastIndexOf(words[words.length - 1])) + words[0]);


        sc.close();
    }
}




















