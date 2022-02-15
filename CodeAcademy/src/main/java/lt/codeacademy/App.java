package lt.codeacademy;


import lt.codeacademy.model.Person;
import lt.codeacademy.utils.FileUtils;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Person> persons = FileUtils.readPeopleFile("data/people.txt");

        FileUtils.readPaymentsFile("data/payment.txt", persons);

        FileUtils.savePersonsSortedByReceivedMoney("data/personsSortedByReceivedMoney.txt", persons);
        FileUtils.savePersonsSortedBySendMoney("data/personsSortedBySendMoney.txt", persons);
    }
}
