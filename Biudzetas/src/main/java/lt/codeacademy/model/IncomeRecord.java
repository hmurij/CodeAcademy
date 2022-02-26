package lt.codeacademy.model;

import lt.codeacademy.type.IncomeType;

import java.time.LocalDate;

public class IncomeRecord extends Record {
    private IncomeType incomeType;
    private boolean incomeReceived;

    public IncomeRecord(double amount,
                        LocalDate date,
                        IncomeType incomeType,
                        boolean incomeReceived,
                        String comments) {
        super(amount, date, comments);
        this.incomeType = incomeType;
        this.incomeReceived = incomeReceived;
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

    @Override
    public String toCsvString() {
        return "I,"
                + String.format("%.2f", getAmount()) + ","
                + getDate() + ","
                + incomeType + ","
                + incomeReceived + ","
                + (getComments().split(" ").length > 1 ? "\"" + getComments() + "\"" : getComments()) + "\n";
    }


    @Override
    public String toString() {
        return "PajamuIrasas{"
                + "id=" + super.getId()
                + ", suma=" + String.format("%.2f", getAmount())
                + ", data=" + getDate()
                + ", kategorija=" + incomeType
                + ", pozymisArIBanka=" + incomeReceived
                + ", papildomaInfo='" + super.getComments() + '\''
                + '}';
    }
}
