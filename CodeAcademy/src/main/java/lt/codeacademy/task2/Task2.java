package lt.codeacademy.task2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> immutableInts = List.of(1, 2, 3, 4, 5);
        List<Integer> mutableInts = new ArrayList<>(immutableInts);
        mutableInts.addAll(List.of(6, 7, 8, 9));
        System.out.println(mutableInts);
    }
}
