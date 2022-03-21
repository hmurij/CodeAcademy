package lt.codeacademy.budget.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "record", schema = "budget")
@Inheritance(strategy = InheritanceType.JOINED)
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private LocalDate date;
    private String comments;

    public Record() {
    }

    public Record(double amount, LocalDate date, String comments) {
        this.amount = amount;
        this.date = date;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return id == record.id;
    }

    public String toCsvString(){
        return "R,"
                + amount + ","
                + (comments.split(" ").length > 1 ? "\"" + comments + "\"" : comments) + "\n";
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", amount=" + String.format("%.2f", amount) +
                ", date=" + date +
                ", comments='" + comments + '\'' +
                '}';
    }
}
