package lt.codeacademy.utils;

import lt.codeacademy.budget.Budget;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Utility class for saving and reading Budget object from file
 */
public class FileUtils {
    /**
     * Reads {@link Budget} object from file Data/data.dat
     */
    public static Budget readBudgetFromFile(String filePath) {
        Budget budget = new Budget();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            budget = (Budget) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nerastas failas: " + filePath);
        }

        return budget;
    }

    /**
     * Writes {@link Budget} object to file Data/data.dat
     */
    public static void saveBudgetToFile(Budget budget, String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(budget);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
