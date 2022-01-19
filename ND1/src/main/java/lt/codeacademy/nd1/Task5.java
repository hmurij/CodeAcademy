package lt.codeacademy.nd1;

import java.time.Month;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String[] months = Arrays.stream(Month.values())
                .map(m -> m.toString().charAt(0) + m.toString().substring(1).toLowerCase())
                .toArray(String[]::new);

        System.out.println(Arrays.stream(months).collect(Collectors.joining(", ")) + ".");

        // a.Išvesti į ekraną
        // i.masyvo dydį;
        System.out.println("\nMasyvo dydis: " + months.length);

        // ii.masyvo pirmą reikšmę.elementą
        System.out.println("\nMasyvo pirmas elementas: " + months[0]);

        // iii.masyvo paskutinis elementas
        System.out.println("\nMasyvo paskutinis elementas: " + months[months.length - 1]);

        // Paprašyti vartotojo įvesti skačių nuo 1 iki 12.
        System.out.println("\nIveskit skačių nuo 1 iki 12: ");
        int sk1 = in.nextInt();

        // c.Išspasudinti
        // i.pasirinkto mėnesio pavadinimas
        System.out.println("\nPasirinkto mėnesio pavadinimas: " + months[sk1 - 1]);

        // ii.*išspausdinti prieš pasirinktą mėnesį einančio mėnesio pavadinimą ir po pasirinkto - mėnesio pavadinimą.
        System.out.println("\nPrieš pasirinkto mėnesio: " + months[sk1 - 2 < 0 ? 11 : sk1 - 2]);
        System.out.println("\nPo pasirinkto mėnesio: " + months[sk1 + 1 > 12 ? 0 : sk1]);

    }
}






