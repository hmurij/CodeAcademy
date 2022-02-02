package lt.codeacademy;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        System.out.printf("|%20s|\n|%20s|\n|%20s|\n|%20s|\n|%-20s|\n", "As", "tikrai", "ismoksiu", "programuoti", "Java");

        String[] sa = new String[5];
        sa[0] = "one";
        sa[1] = "two";

        System.out.println();
        System.out.println(putInArray(sa, "three"));
        System.out.println(Arrays.toString(sa));
        System.out.println(putInArray(sa, "four"));
        System.out.println(Arrays.toString(sa));
        System.out.println(putInArray(sa, "five"));
        System.out.println(Arrays.toString(sa));
        System.out.println(putInArray(sa, "six"));
        System.out.println(Arrays.toString(sa));

    }

    public static boolean putInArray(String[] array, String text) {

        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                array[i] = text;
                result = true;
                break;
            }
        }

        return result;
    }
}
