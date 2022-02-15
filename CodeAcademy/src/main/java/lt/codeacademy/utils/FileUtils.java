package lt.codeacademy.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtils {

    public static void writeObjectToFile(String filePath, Object object) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filePath))) {
            output.writeObject(object);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readObjectFromFile(String filePath) {
        Object object = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath))) {

            object = input.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
