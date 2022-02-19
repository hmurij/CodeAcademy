package lt.codeacademy.budget;

import lt.codeacademy.model.DebitRecord;
import lt.codeacademy.model.IncomeRecord;
import lt.codeacademy.model.Record;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
}