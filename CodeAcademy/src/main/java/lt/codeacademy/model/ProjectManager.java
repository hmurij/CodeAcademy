package lt.codeacademy.model;

import lt.codeacademy.type.Duties;

public class ProjectManager extends Employee {

    private static int totalLikes = 0;

    public ProjectManager(String name, Duties duties) {
        super(name, duties);
    }

    @Override
    public void takeLike(Employee employee) {
        super.takeLike(employee);
        totalLikes++;
    }

    public static int getTotalLikes(){
        return totalLikes;
    }

    @Override
    public String toString() {
        return "ProjectManager{" +
                "name=" + super.getName() +
                ", duties=" + super.getDuties() +
                ", like=" + super.getNumberOfLikes() +
                '}';
    }

    @Override
    public boolean freeParking() {
        return true;
    }

    @Override
    public boolean freeCarRent() {
        return true;
    }

    @Override
    public boolean freeLunch() {
        return true;
    }
}
