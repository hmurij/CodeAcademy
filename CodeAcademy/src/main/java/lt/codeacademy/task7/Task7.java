package lt.codeacademy.task7;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Task7 {
    public static void main(String[] args) {
        Duration days = Duration.ofDays(15);
        System.out.println(TimeUnit.HOURS.convert(days));
        System.out.println(TimeUnit.MINUTES.convert(days));
        System.out.println(TimeUnit.SECONDS.convert(days));
        System.out.println(TimeUnit.MILLISECONDS.convert(days));
        System.out.println(TimeUnit.MICROSECONDS.convert(days));
        System.out.println(TimeUnit.NANOSECONDS.convert(days));
    }
}
