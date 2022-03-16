package lt.codeacademy.model;

import java.time.LocalDate;

public class Record {
    private static int nextId = 1;

    private final int id;
    private double amount;
    private LocalDate date;
    private String comments;

    public Record(double amount, LocalDate date, String comments) {
        this.id = generateId();
        this.amount = amount;
        this.date = date;
        this.comments = comments;
    }

    private int generateId(){
        return nextId++;
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
