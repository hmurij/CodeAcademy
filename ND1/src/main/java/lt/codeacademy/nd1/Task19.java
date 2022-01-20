package lt.codeacademy.nd1;

import java.util.Random;

public class Task19 {
    public static void main(String[] args) {
        // 6 boolean tipo kintamujų ir priskirti reikšmes. Kintamiesiams parašyti po IF sakinį,
        // ir jei boolean reikšmė true, išspausdinti teksta su kintamojo vardu
        Random r = new Random();

        boolean b1 = r.nextBoolean();
        boolean b2 = r.nextBoolean();
        boolean b3 = r.nextBoolean();
        boolean b4 = r.nextBoolean();
        boolean b5 = r.nextBoolean();
        boolean b6 = r.nextBoolean();

        boolean[] ba = {b1, b2, b3, b4, b5, b6};

        for (int i = 0; i < ba.length; i++) {
            if (ba[i]) {
                System.out.println("b" + (i + 1) + " - " + ba[i]);
            }
        }

        // Panaudoti primityvius skaičių (po du) topus IF sakiniuose
        // ir išspausdinti ar reikšmes yra:
        // a.Lygios

        int a = r.nextInt(10) + 1;
        int b = r.nextInt(10) + 1;

        System.out.println("\na = " + a + "\nb = " + b + "\n");

        if (a == b) {
            System.out.println(a + " == " + b);
        }

        // b.Pirma mažesnė
        if (a < b) {
            System.out.println(a + " < " + b);
        }

        // c.Pirma didesnė
        if (a > b) {
            System.out.println(a + " > " + b);
        }

        // Panaudoti primityvių skaičių topus IF sakiniuose ir išspausdinti ar reikšmes yra:
        // a.Pirma mažesnė arba lygios
        if (a <= b) {
            System.out.println(a + " <= " + b);
        }

        // b.Pirma didesnė arba lygios
        if (a >= b) {
            System.out.println(a + " >= " + b);
        }
    }
}























