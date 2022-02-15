package lt.codeacademy.utils;

import lt.codeacademy.model.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

    public static List<Person> readPeopleFile(String filePath) {
        List<Person> persons = List.of();

        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));

            persons = lines.subList(1, lines.size()).stream().map(l -> {
                String[] fields = l.split(",");
                return new Person(Integer.parseInt(fields[0]), fields[1].trim(), fields[2].trim());
            }).collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }

    public static void readPaymentsFile(String filePath, List<Person> persons) {

        try {
            List<String> payments = Files.readAllLines(Path.of(filePath));

            payments.subList(1, payments.size()).forEach(payment -> {
                String[] data = payment.split(",");

                int id = Integer.parseInt(data[0]);
                double amount = Integer.parseInt(data[1].trim());
                int receiverId = Integer.parseInt(data[2].trim());
                int senderId = Integer.parseInt(data[3].trim());

                persons.forEach(person -> {
                    if (person.getId() == receiverId) {
                        person.updateReceivedMoney(amount);
                    } else if (person.getId() == senderId) {
                        person.updateSendMoney(amount);
                    }
                });

            });
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void savePersonsSortedByReceivedMoney(String filePath, List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getReceivedMoney).reversed());

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("id,fistName,lastName,receivedMoney,sendMoney\n");
            for (Person p : persons) {
                writer.write(p.getId() + "," +
                        p.getFirstName() + "," +
                        p.getLastName() + "," +
                        p.getReceivedMoney() + "," +
                        p.getSentMoney() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savePersonsSortedBySendMoney(String filePath, List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getSentMoney).reversed());

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("id,fistName,lastName,receivedMoney,sendMoney\n");
            for (Person p : persons) {
                writer.write(p.getId() + "," +
                        p.getFirstName() + "," +
                        p.getLastName() + "," +
                        p.getReceivedMoney() + "," +
                        p.getSentMoney() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
