package lt.codeacademy;


import lt.codeacademy.model.Person;
import lt.codeacademy.utils.FileUtils;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Person> persons = FileUtils.readPeopleFile("people.txt");

        FileUtils.readPaymentsFile("payment.txt", persons);

        FileUtils.savePersonsSortedByReceivedMoney("personsSortedByReceivedMoney.txt", persons);
        FileUtils.savePersonsSortedBySendMoney("personsSortedBySendMoney.txt", persons);
    }
}
