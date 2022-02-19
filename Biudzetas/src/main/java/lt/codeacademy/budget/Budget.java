package lt.codeacademy.budget;

import lt.codeacademy.model.DebitRecord;
import lt.codeacademy.model.IncomeRecord;

import java.io.Serializable;
import java.util.Arrays;

public class Budget implements Serializable {
    private IncomeRecord[] incomeRecords;
    private int incomeRecordSize;

    private DebitRecord[] debitRecords;
    private int debitRecordsSize;

    public Budget() {
        incomeRecords = new IncomeRecord[1];
        debitRecords = new DebitRecord[1];

        incomeRecordSize = 0;
        debitRecordsSize = 0;
    }

    /**
     * Add new income record
     *
     * @param incomeRecord new income record
     */
    public void addIncomeRecord(IncomeRecord incomeRecord) {
        if (incomeRecordSize == incomeRecords.length) {
            incomeRecords = Arrays.copyOf(incomeRecords, incomeRecords.length * 2);
        }

        if (incomeRecord != null) {
            incomeRecords[incomeRecordSize] = incomeRecord;
            incomeRecordSize++;
        }
    }

    public IncomeRecord[] getIncomeRecords() {
        return Arrays.copyOf(incomeRecords, incomeRecordSize);
    }

    /**
     * Add new debit record
     *
     * @param debitRecord new debit record
     */
    public void addDebitRecord(DebitRecord debitRecord) {
        if (debitRecordsSize == debitRecords.length) {
            debitRecords = Arrays.copyOf(debitRecords, debitRecords.length * 2);
        }

        if (debitRecord != null) {
            debitRecords[debitRecordsSize] = debitRecord;
            debitRecordsSize++;
        }
    }

    /**
     * Returns filled up part of pajamuIrasai array
     *
     * @return part or complete pajamuIrasai array
     */
    public DebitRecord[] getDebitRecords() {
        return Arrays.copyOf(debitRecords, debitRecordsSize);
    }
}