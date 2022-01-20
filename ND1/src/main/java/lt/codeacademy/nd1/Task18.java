package lt.codeacademy.nd1;

public class Task18 {
    public static void main(String[] args) {
        // apsirašyti du int tipo kintamuosius
        int a = 1;
        int b = 2;

        // 1 . Palyginti jų reikšmes, ir rezultatą priskirti boolean kintamiesiams: intTest

        boolean intTest = a > b ? true : false;
        System.out.println(a + " > " + b + " - " + intTest);

        intTest = a >= b ? true : false;
        System.out.println(a + " >= " + b + " - " + intTest);

        intTest = a == b ? true : false;
        System.out.println(a + " == " + b + " - " + intTest);
        
        intTest = a <= b ? true : false;
        System.out.println(a + " <= " + b + " - " + intTest);

        intTest = a < b ? true : false;
        System.out.println(a + " < " + b + " - " + intTest);

    }
}
