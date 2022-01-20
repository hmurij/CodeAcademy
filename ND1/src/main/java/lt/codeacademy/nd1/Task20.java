package lt.codeacademy.nd1;

import java.time.DayOfWeek;
import java.util.Arrays;

/**
 * Klasės main metode kviečiamas jūsų sukurtas naujas void metodas
 * rodykDiena(int savaitiesDiena). Naujame metode panaudoti switch sakinį su int savaitiesDiena kintamuoju
 */
public class Task20 {
    public static void main(String[] args) {
        for (int i = 0; i <= 8; i++) {
            rodykDiena(i);
            System.out.println();
        }
    }

    /**
     * Takes int as parameter and prints to console corresponding day of the week.
     * In case of invalid week day number prints appropriate message.
     *
     * @param savaitiesDiena int value in range from 1 to 7
     */
    public static void rodykDiena(int savaitiesDiena) {
        if (savaitiesDiena >= 1 && savaitiesDiena <= 7) {
            System.out.println(Arrays.stream(DayOfWeek.values()).filter(d -> d.getValue() == savaitiesDiena)
                    .map(d -> d.toString().charAt(0) + d.toString().substring(1).toLowerCase()).findAny().get());
        } else {
            System.out.println("Invalid parameter: " + savaitiesDiena
                    + "\nPlease enter value in range from 1 to 7");
        }
    }
}
