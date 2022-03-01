package lt.codeacademy.task4;

/*

    Naudojantis datų iteravimo pavyzdžiu ir String klasės metodu repeat(...)
    atspausdinkitevisas datas nuo 2019-01-01 iki 2019-02-1

 */

import java.time.LocalDate;

public class Task4 {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2019, 01, 01);
        LocalDate end = LocalDate.of(2019, 02, 01);

        start.datesUntil(end.plusDays(1)).forEach(date -> {
            System.out.printf("%s%s\n", " ".repeat(date.getDayOfMonth() < 15 ? date.getDayOfMonth() : 31 - date.getDayOfMonth()), date);
        });

    }
}
