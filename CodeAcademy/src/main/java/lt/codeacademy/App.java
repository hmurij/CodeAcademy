package lt.codeacademy;

import lt.codeacademy.model.Developer;
import lt.codeacademy.model.Employee;
import lt.codeacademy.model.ProjectManager;
import lt.codeacademy.type.Duties;
import lt.codeacademy.type.Rank;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Employee e1 = new ProjectManager("John Doe", Duties.MANAGER);
        Employee e2 = new Developer("Jane Woe", Duties.DEVELOPER, Rank.JUNIOR);
        Employee e3 = new Developer("Harry Hacker", Duties.DEVELOPER, Rank.MID);
        Employee e4 = new Developer("Carry Cracker", Duties.DEVELOPER, Rank.SENIOR);

        List<Employee> el = List.of(e1, e2, e3, e4);

        displayStatistics(el);

        e1.like(e2);
        e2.like(e3);
        e3.like(e4);
        e4.like(e1);
        e4.like(e2);
        e4.like(e3);
        e3.like(e1);
        e3.like(e3);

        displayStatistics(el);

        displayLikedEmployee(e3);
    }

    private static void displayStatistics(List<Employee> el) {
        for (Employee e : el) {
            System.out.println(e.toString());
        }

        System.out.println("Project Managers total likes: " + ProjectManager.getTotalLikes());
        System.out.println("Developers total likes: " + Developer.getTotalLikes());
        System.out.println("Total likes: " + Employee.getTotalLikes());
        System.out.println();
    }

    private static void displayLikedEmployee(Employee employee) {
        System.out.println("-".repeat(40));
        System.out.println(employee.getName() + " received likes from: ");
        for (Employee e: employee.getLikedEmployees()) {
            System.out.println("\t- " + e.getName());
        }
        System.out.println("-".repeat(40));

    }
}

