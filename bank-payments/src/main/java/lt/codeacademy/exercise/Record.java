package lt.codeacademy.exercise;

import java.time.LocalDate;
import java.util.Objects;

public class Record {
    private String bankName;
    private LocalDate date;
    private double amount;
    private String payerName;
    private String accountNr;

    public Record(String bankName, LocalDate date, double amount, String payerName, String accountNr) {
        this.bankName = bankName;
        this.date = date;
        this.amount = amount;
        this.payerName = payerName;
        this.accountNr = accountNr;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Double.compare(record.amount, amount) == 0 &&
                Objects.equals(bankName, record.bankName) &&
                Objects.equals(date, record.date) &&
                Objects.equals(payerName, record.payerName) &&
                Objects.equals(accountNr, record.accountNr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, date, amount, payerName, accountNr);
    }

    @Override
    public String toString() {
        return "Record{" +
                "bankName='" + bankName + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", payerName='" + payerName + '\'' +
                ", accountNr='" + accountNr + '\'' +
                '}';
    }
}
