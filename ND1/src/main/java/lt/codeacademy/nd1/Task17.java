package lt.codeacademy.nd1;

public class Task17 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("grazinkIrPadidink(" + i + ") = " + grazinkIrPadidink(i));
            System.out.println("padidinkIrGrazink(" + i + ") = " + padidinkIrGrazink(i) + "\n");
        }

    }

    /**
     * Returns and increments parameter
     *
     * @param i any arbitrary number in range -2147483648 to 2147483647
     * @return parameter without changes
     */
    public static int grazinkIrPadidink(int i) {
        return i++;
    }

    /**
     * Returns incremented by 1 parameter
     *
     * @param i any arbitrary number in range -2147483648 to 2147483647
     * @return by 1 incremented parameter and then increments
     */
    public static int padidinkIrGrazink(int i) {
        return ++i;
    }
}
