package lt.codacademy.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        InputStream resource = App.class.getClassLoader().getResourceAsStream("database.properties");
        Properties properties = new Properties();
        try {
            properties.load(resource);
            String url = properties.getProperty("db.jdbc.url");
            String user = properties.getProperty("db.jdbc.user");
            String password = properties.getProperty("db.jdbc.password");
            System.out.println("url: " + url + "\nuser: " + user + "\npassword: " + password);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
//            Connection connection = DriverManager
//                    .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "12345");
            Connection connection = DriverManager
                    .getConnection(
                            System.getProperty("db.jdbc.url"),
                            System.getProperty("db.jdbc.user"),
                            System.getProperty("db.jdbc.password"));
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
