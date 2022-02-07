package lt.codeacademy;

public class Calculator {
    private final int a;
    private final int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int addition(){
        return a + b;
    }
    
    public int subtraction(){
        return a - b;
    }

    public int multiplication(){
        return a * b;
    }

    public int division(){
        return a / b;
    }
}
