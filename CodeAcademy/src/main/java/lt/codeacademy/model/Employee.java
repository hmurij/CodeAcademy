package lt.codeacademy.model;

import lt.codeacademy.Service.GiveLike;
import lt.codeacademy.Service.TakeLike;
import lt.codeacademy.type.Duties;

public abstract class Employee implements GiveLike, TakeLike {

    public static int totalEmployeeLikes = 0;

    private String name;
    private Duties duties;

    public Employee(String name, Duties duties) {
        this.name = name;
        this.duties = duties;
    }

    public String getName() {
        return name;
    }

    public Duties getDuties() {
        return duties;
    }

    @Override
    public void like(Employee employee) {
        employee.takeLike();
    }

    @Override
    public void takeLike() {
        totalEmployeeLikes++;
    }
}
