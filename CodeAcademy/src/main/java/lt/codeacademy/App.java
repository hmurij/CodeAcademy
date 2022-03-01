package lt.codeacademy;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        List<Integer> ints = List.of(2, 4, 5, 3, 8, 1, 7, 6);
        ints.sort(Integer::compareTo);
        System.out.println(ints);
    }
}
