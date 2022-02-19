package lt.codeacademy.model;

import lt.codeacademy.type.IncomeType;

import java.io.Serializable;
import java.time.LocalDate;

public class IncomeRecord implements Serializable {
    private double amount;
    private LocalDate date;
    private IncomeType incomeType;
    private boolean incomeReceived;
    private String comments;

    public IncomeRecord() {
    }

    public IncomeRecord(double amount,
                        LocalDate date,
                        IncomeType incomeType,
                        boolean incomeReceived,
                        String comments) {
        this.amount = amount;
        this.date = date;
        this.incomeType = incomeType;
        this.incomeReceived = incomeReceived;
        this.comments = comments;
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

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }

    public boolean isIncomeReceived() {
        return incomeReceived;
    }

    public void setIncomeReceived(boolean incomeReceived) {
        this.incomeReceived = incomeReceived;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "PajamuIrasas{" +
                "suma=" + amount +
                ", data=" + date +
                ", kategorija=" + incomeType +
                ", pozymisArIBanka=" + incomeReceived +
                ", papildomaInfo='" + comments + '\'' +
                '}';
    }
}
