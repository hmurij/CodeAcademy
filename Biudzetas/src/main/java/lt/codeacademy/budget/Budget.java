package lt.codeacademy.budget;

import lt.codeacademy.model.DebitRecord;
import lt.codeacademy.model.IncomeRecord;
import lt.codeacademy.model.Record;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Budget implements Serializable {
    private final List<Record> records;

    public Budget() {
        records = new ArrayList<>();
    }

    /**
     * Add new income record
     *
     * @param record new record
     */
    public void addRecord(Record record) {
        records.add(record);
    }

    public List<IncomeRecord> getIncomeRecords() {
        return records.stream().filter(IncomeRecord.class::isInstance)
                .map(record -> (IncomeRecord) record).collect(Collectors.toList());
    }

    public List<DebitRecord> getDebitRecords() {
        return records.stream().filter(DebitRecord.class::isInstance)
                .map(record -> (DebitRecord) record).collect(Collectors.toList());
    }

    /**
     * Deletes record with provided id
     * @param id of record to be deleted
     * @return true if record is deleted, false otherwise
     */
    public boolean deleteRecord(int id) {
        Optional<Record> deleteRecord = records.stream().filter(record -> record.getId() == id).findAny();
        deleteRecord.ifPresent(records::remove);
        return deleteRecord.isPresent();
    }

    /**
     * Calculates balance of the budget.
     *
     * @return budget balance
     */
    public double getBalance() {
        return getTotalIncome() - getTotalDebit();
    }

    public double getTotalDebit() {
        return records.stream().filter(DebitRecord.class::isInstance)
                .mapToDouble(Record::getAmount).sum();
    }

    public double getTotalIncome() {
        return records.stream().filter(IncomeRecord.class::isInstance)
                .mapToDouble(Record::getAmount).sum();
    }
}