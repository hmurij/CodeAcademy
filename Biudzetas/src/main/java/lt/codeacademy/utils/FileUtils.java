package lt.codeacademy.utils;

import lt.codeacademy.model.Biudzetas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Utility class for saving and reading Biudzetas object from file
 */
public class FileUtils {
    /**
     * Reads {@link Biudzetas} object from file Data/data.dat
     */
    public static Biudzetas readBiudzetasFromFile(String filePath) {
        Biudzetas biudzetas = new Biudzetas();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            biudzetas = (Biudzetas) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nerastas failas: " + filePath);
        }

        return biudzetas;
    }

    /**
     * Writed {@link Biudzetas} object to file Data/data.dat
     */
    public static void saveBiudzetasToFile(Biudzetas biudzetas, String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(biudzetas);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
