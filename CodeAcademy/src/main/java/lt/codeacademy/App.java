package lt.codeacademy;


import java.util.function.BiFunction;

public class App {
    public static void main(String[] args) {

        SimpleMath sm = (a, b) -> "" + (a + b) + SimpleMath.sub(a, b);

        System.out.println(sm.sum(3, 5));
        System.out.println(sum().apply(2, 5));
    }

    public static BiFunction<Integer, Integer, Integer> sum() {
       return (a, b) -> a + b;
    }
}

interface SimpleMath{
    String sum(int a, int b);

    static String sub(int a, int b) {
        return "" + (a - b);
    }
}


