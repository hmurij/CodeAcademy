package lt.codeacademy.budget.entity;

import lt.codeacademy.type.DebitType;
import lt.codeacademy.type.PaymentType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "debit_record", schema = "budget")
public class DebitRecord extends Record {
    private LocalTime time;
    private DebitType debitType;
    private PaymentType paymentType;

    public DebitRecord() {
    }

    public DebitRecord(double amount,
                       LocalDate date,
                       LocalTime time,
                       DebitType debitType,
                       PaymentType paymentType,
                       String comments) {
        super(amount, date, comments);
        this.time = time;
        this.debitType = debitType;
        this.paymentType = paymentType;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public DebitType getDebitType() {
        return debitType;
    }

    public void setDebitType(DebitType debitType) {
        this.debitType = debitType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toCsvString(){
        return "D,"
                + String.format("%.2f", getAmount()) + ","
                + String.format("%s %2$tH:%2$tM", getDate(), time) + ","
                + debitType + ","
                + paymentType + ","
                + (getComments().split(" ").length > 1 ? "\"" + getComments() + "\"" : getComments()) + "\n";
    }

    @Override
    public String toString() {
        return "DebitRecord{"
                + "id=" + getId()
                + ", amount=" + String.format("%.2f", getAmount())
                + ", data=" + getDate()
                + ", laikas= " + time
                + ", kategorija=" + debitType
                + ", paymentType=" + paymentType
                + ", papildomaInfo='" + getComments() + '\'' +
                '}';
    }
}
