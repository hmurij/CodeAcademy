package lt.codeacademy.model;

import lt.codeacademy.type.Duties;
import lt.codeacademy.type.Rank;

public class Developer extends Employee{

    public static int totalDeveloperLikes = 0;

    private Rank rank;
    private int like = 0;

    public Developer(String name, Duties duties, Rank rank) {
        super(name, duties);
        this.rank = rank;

    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public void takeLike() {
        super.takeLike();
        like++;
        totalDeveloperLikes++;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name=" + super.getName() +
                ", duties=" + super.getDuties() +
                ", rank=" + rank +
                ", like=" + like +
                '}';
    }
}
