package lt.codeacademy.model;

import lt.codeacademy.type.DebitType;
import lt.codeacademy.type.PaymentType;

import java.time.LocalDate;
import java.time.LocalTime;

public class DebitRecord extends Record {
    private LocalTime time;
    private DebitType debitType;
    private PaymentType paymentType;

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
    public String toString() {
        return "DebitRecord{"
                + "amount=" + getAmount()
                + ", data=" + getDate()
                + ", laikas= " + time
                + ", kategorija=" + debitType
                + ", paymentType=" + paymentType
                + ", papildomaInfo='" + getComments() + '\'' +
                '}';
    }
}
