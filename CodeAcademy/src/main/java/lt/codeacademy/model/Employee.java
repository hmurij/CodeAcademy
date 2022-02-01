package lt.codeacademy.model;

import lt.codeacademy.Interface.ExtraRights;
import lt.codeacademy.Interface.GiveLike;
import lt.codeacademy.Interface.TakeLike;
import lt.codeacademy.type.Duties;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee implements GiveLike, TakeLike, ExtraRights {

    private static int totalLikes = 0;

    private String name;
    private Duties duties;
    private List<Employee> likedEmployees;

    public Employee(String name, Duties duties) {
        this.name = name;
        this.duties = duties;
        this.likedEmployees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Duties getDuties() {
        return duties;
    }

    public List<Employee> getLikedEmployees(){
        return List.copyOf(this.likedEmployees);
    }

    public int getNumberOfLikes(){
        return this.likedEmployees.size();
    }

    public static int getTotalLikes(){
        return totalLikes;
    }

    @Override
    public void like(Employee employee) {
        employee.takeLike(this);
    }

    @Override
    public void takeLike(Employee employee) {
        if(!this.equals(employee)){
            likedEmployees.add(employee);
            totalLikes++;
        }
    }
}
