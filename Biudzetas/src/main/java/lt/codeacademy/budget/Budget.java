package lt.codeacademy.budget;

import lt.codeacademy.budget.entity.DebitRecord;
import lt.codeacademy.budget.entity.IncomeRecord;
import lt.codeacademy.budget.entity.Record;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Budget {
    private final List<Record> records;

    public Budget() {
        this(new ArrayList<>());
    }

    public Budget(List<Record> records) {
        this.records = records;
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
                .map(IncomeRecord.class::cast).collect(Collectors.toList());
    }

    public List<DebitRecord> getDebitRecords() {
        return records.stream().filter(DebitRecord.class::isInstance)
                .map(DebitRecord.class::cast).collect(Collectors.toList());
    }

    /**
     * Retrieves record of specified type by id.
     *
     * @param id of the record
     * @param type record class
     * @return Optional containing record if found, empty optional otherwise
     */
    public <T extends Record> Optional<T> getRecordById(int id, Class<T> type) {
        return records.stream().filter(type::isInstance).map(type::cast).filter(record -> record.getId() == id).findAny();
    }

    /**
     * Replaces record with edited record
     *
     * @param record edited record
     */
    public void editRecord(Record record) {
        if (deleteRecord(record.getId())) {
            addRecord(record);
        }
    }

    /**
     * Deletes record with provided id
     *
     * @param id of record to be deleted
     * @return true if record is deleted, false otherwise
     */
    public boolean deleteRecord(int id) {
        Optional<? extends Record> deleteRecord = getRecordById(id, Record.class);
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