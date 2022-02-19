package lt.codeacademy.model;

import lt.codeacademy.type.PaymentType;
import lt.codeacademy.type.DebitType;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DebitRecord implements Serializable {
    private double amount;
    private LocalDateTime dateTime;
    private DebitType debitType;
    private PaymentType paymentType;
    private String comments;

    public DebitRecord() {
    }

    public DebitRecord(double amount,
                       LocalDateTime dateTime,
                       DebitType debitType,
                       PaymentType paymentType,
                       String comments) {
        this.amount = amount;
        this.dateTime = dateTime;
        this.debitType = debitType;
        this.paymentType = paymentType;
        this.comments = comments;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "DebitRecord{" +
                "amount=" + amount +
                ", dataTime=" + dateTime +
                ", kategorija=" + debitType +
                ", paymentType=" + paymentType +
                ", papildomaInfo='" + comments + '\'' +
                '}';
    }
}
