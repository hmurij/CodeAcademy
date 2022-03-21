package lt.codeacademy.budget;

import lt.codeacademy.budget.entity.DebitRecord;
import lt.codeacademy.budget.entity.IncomeRecord;
import lt.codeacademy.budget.entity.Record;
import lt.codeacademy.budget.service.RecordService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Budget {
    private RecordService recordService;

    public Budget(RecordService recordService) {
        this.recordService = recordService;
    }

    public Budget(List<Record> records, RecordService recordService) {
        this(recordService);
        records.forEach(this::addRecord);
    }

    /**
     * Add new income record
     *
     * @param record new record
     */
    public void addRecord(Record record) {
        recordService.save(record);
    }

    public List<IncomeRecord> getIncomeRecords() {
        return recordService.findAll().stream()
                .filter(IncomeRecord.class::isInstance)
                .map(IncomeRecord.class::cast)
                .collect(Collectors.toList());
    }

    public List<DebitRecord> getDebitRecords() {
        return recordService.findAll().stream()
                .filter(DebitRecord.class::isInstance)
                .map(DebitRecord.class::cast)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves record of specified type by id.
     *
     * @param id   of the record
     * @param type record class
     * @return Optional containing record if found, empty optional otherwise
     */
    public <T extends Record> Optional<T> getRecordById(int id, Class<T> type) {
        return recordService.getById(id, type);
    }

    /**
     * Replaces record with edited record
     *
     * @param record edited record
     */
    public void editRecord(Record record) {
        recordService.getById(record.getId(), Record.class).ifPresent(foundRecord -> recordService.edit(record));
    }

    /**
     * Deletes record with provided id
     *
     * @param id of record to be deleted
     * @return true if record is deleted, false otherwise
     */
    public boolean deleteRecord(int id) {
        return recordService.getById(id, Record.class)
                .map(record -> {
                    recordService.delete(record);
                    return true;
                }).orElse(false);
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
        return getDebitRecords().stream().mapToDouble(Record::getAmount).sum();
    }

    public double getTotalIncome() {
        return getIncomeRecords().stream().mapToDouble(Record::getAmount).sum();
    }
}