package lt.codeacademy.model;

import lt.codeacademy.type.Duties;
import lt.codeacademy.type.Rank;

public class Developer extends Employee {

    private static int totalLikes = 0;

    private Rank rank;

    public Developer(String name, Duties duties, Rank rank) {
        super(name, duties);
        this.rank = rank;

    }

    public Rank getRank() {
        return rank;
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
        return "Developer{" +
                "name=" + super.getName() +
                ", duties=" + super.getDuties() +
                ", rank=" + rank +
                ", like=" + super.getNumberOfLikes() +
                '}';
    }

    @Override
    public boolean freeParking() {
        if(rank == Rank.SENIOR)
            return true;
        else
            return false;
    }

    @Override
    public boolean freeCarRent() {
        return false;
    }

    @Override
    public boolean freeLunch() {
        return true;
    }
}
