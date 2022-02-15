package lt.codeacademy;


import lt.codeacademy.model.Person;
import lt.codeacademy.utils.FileUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class App
{
    public static void main( String[] args )
    {
        FileUtils.writeObjectToFile("person.dat", generateListOfPersons());

        List<Person> newPerson = (List<Person>) FileUtils.readObjectFromFile("person.dat");
        newPerson.forEach(System.out::println);
    }

    private static List<Person> generateListOfPersons(){
        Person person1 = new Person("John",
                "Doe",
                LocalDate.now().minusDays(365 * 10 - ((new Random()).nextInt(365 * 10))));
        Person person2 = new Person("Jane",
                "Woe",
                LocalDate.now().minusDays(365 * 10 - ((new Random()).nextInt(365 * 10))));
        Person person3 = new Person("Harry",
                "Hacker",
                LocalDate.now().minusDays(365 * 10 - ((new Random()).nextInt(365 * 10))));

        List<Person> persons = List.of(person1, person2, person3);
        return persons;
    }
}
