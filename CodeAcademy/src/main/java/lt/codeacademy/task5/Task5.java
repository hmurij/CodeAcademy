package lt.codeacademy.task5;

import java.util.HashMap;
import java.util.Map;

public class Task5 {
    public static void main(String[] args) {
        var map = new HashMap<Integer, String>();
        map.putAll(Map.of(1, "One", 2, "Two", 3, "Three"));
        System.out.println(map);
    }
}
