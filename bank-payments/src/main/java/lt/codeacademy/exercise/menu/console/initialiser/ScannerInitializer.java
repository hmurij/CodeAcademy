package lt.codeacademy.exercise.menu.console.initialiser;

import java.util.Scanner;

/**
 * Initializer class to have only one scanner object through application
 */
public final class ScannerInitializer {

    private static Scanner scanner;

    private ScannerInitializer() {}

    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        return scanner;
    }
}
