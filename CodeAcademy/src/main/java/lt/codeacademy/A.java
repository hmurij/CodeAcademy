package lt.codeacademy;

public class A {
    public static void main(String[] args) {

        try {
//            m1();
            B.m1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void m1() throws E1, E2, E3 {
        m2();
        m3();
        m4();
    }

    static void m2() throws E1 {
        throw new E1("m2 throws E1");
    }

    static void m3() throws E2 {
        throw new E2("m3 throws E2");
    }

    static void m4() throws E3 {
        throw new E3("m4 throws E3");
    }

}

class B {
    static void m1() throws E1, E2, E3 {
        m2();
        m3();
        m4();
    }

    static void m2()  {
        int a = 2 / 0;
    }

    static void m3()  {
        int[] array = {1, 2, 3, 4, 5};
        int a = array[7];
    }

    static void m4()  {
        String string = null;
        string.length();
    }

}

class E1 extends Exception {
    public E1(String message) {
        super(message);
    }
}

class E2 extends Exception {
    public E2(String message) {
        super(message);
    }
}

class E3 extends Exception {
    public E3(String message) {
        super(message);
    }
}
