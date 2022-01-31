package lt.codeacademy.model;

import lt.codeacademy.type.Duties;

public class ProjectManager extends Employee{

    public static int totalManagerLikes = 0;

    private int like = 0;

    public ProjectManager(String name, Duties duties) {
        super(name, duties);
    }

    @Override
    public void takeLike() {
        super.takeLike();
        totalManagerLikes++;
        like++;
    }

    @Override
    public String toString() {
        return "ProjectManager{" +
                "name=" + super.getName() +
                ", duties=" + super.getDuties() +
                ", like=" + like +
                '}';
    }
}
