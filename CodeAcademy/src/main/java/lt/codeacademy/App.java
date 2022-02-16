package lt.codeacademy;

import lt.codeacademy.model.Person;

public class App {
    public static void main(String[] args) {
        GenericBox<Person> personListBox = new PersonListBox();

        printArray(new Integer[]{1, 2, 3});
        printArray(new String[]{"Hello", "World"});
    }

    private static <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
