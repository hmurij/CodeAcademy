package lt.codeacademy.budget.dao;

import lt.codeacademy.budget.entity.DebitRecord;
import lt.codeacademy.budget.entity.IncomeRecord;
import lt.codeacademy.budget.entity.Record;
import lt.codeacademy.factory.BudgetFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RecordDaoHibernateImplTest {
    private RecordDaoHibernateImpl recordDaoHibernate = new RecordDaoHibernateImpl();

    @AfterEach
    void clearDb() {
        recordDaoHibernate.findAll().forEach(recordDaoHibernate::delete);
    }

    @Test
    void record_save_recordSaved() {
        Record record = BudgetFactory.generateIncomeRecord();

        recordDaoHibernate.save(record);

        assertTrue(recordDaoHibernate.findAll().contains(record));
    }

    @Test
    void noRecords_findAll_emptyList() {
        List<Record> records = recordDaoHibernate.findAll();

        assertEquals(0, records.size());
    }

    @Test
    void debitIncomeRecords_findAll_retrievedRecordsEqualGivenRecords() {
        List<IncomeRecord> incomeRecords = Stream.generate(BudgetFactory::generateIncomeRecord).limit(5).collect(Collectors.toList());
        List<DebitRecord> debitRecords = Stream.generate(BudgetFactory::generateDebitRecord).limit(5).collect(Collectors.toList());
        List<Record> records = Stream.of(incomeRecords, debitRecords).flatMap(Collection::stream).collect(Collectors.toList());
        records.forEach(recordDaoHibernate::save);

        List<Record> retrievedRecords = recordDaoHibernate.findAll();

        assertEquals(records, retrievedRecords);
    }

    @Test
    void debitRecordValidId_findById_retrievedRecordEqualsGivenRecord() {
        DebitRecord debitRecord = BudgetFactory.generateDebitRecord();
        recordDaoHibernate.save(debitRecord);
        int id = debitRecord.getId();

        Optional<DebitRecord> retrievedDebitRecord = recordDaoHibernate.getById(id, DebitRecord.class);

        assertEquals(debitRecord, retrievedDebitRecord.orElse(null));
    }

    @Test
    void incomeRecordValidId_findById_retrievedRecordEqualsGivenRecord() {
        IncomeRecord incomeRecord = BudgetFactory.generateIncomeRecord();
        recordDaoHibernate.save(incomeRecord);
        int id = incomeRecord.getId();

        Optional<IncomeRecord> retrievedDebitRecord = recordDaoHibernate.getById(id, IncomeRecord.class);

        assertEquals(incomeRecord, retrievedDebitRecord.orElse(null));
    }

    @Test
    void recordValidId_findById_retrievedRecordEqualsGivenRecord() {
        Record record = BudgetFactory.generateIncomeRecord();
        recordDaoHibernate.save(record);
        int id = record.getId();

        Optional<Record> retrievedDebitRecord = recordDaoHibernate.getById(id, Record.class);

        assertEquals(record, retrievedDebitRecord.orElse(null));
    }

    @Test
    void debitRecordInvalidId_findById_emptyOptional() {
        DebitRecord debitRecord = BudgetFactory.generateDebitRecord();
        recordDaoHibernate.save(debitRecord);
        int id = -1;

        Optional<DebitRecord> retrievedDebitRecord = recordDaoHibernate.getById(id, DebitRecord.class);

        assertTrue(retrievedDebitRecord.isEmpty());
    }

    @Test
    void editedRecord_edit_recordEdited() {
        DebitRecord debitRecord = BudgetFactory.generateDebitRecord();
        recordDaoHibernate.save(debitRecord);
        DebitRecord editedDebitRecord = BudgetFactory.generateDebitRecord();
        debitRecord.setAmount(editedDebitRecord.getAmount());
        debitRecord.setDebitType(editedDebitRecord.getDebitType());
        debitRecord.setPaymentType(editedDebitRecord.getPaymentType());
        debitRecord.setDate(editedDebitRecord.getDate());

        recordDaoHibernate.edit(debitRecord);

        DebitRecord retrievedRecord = recordDaoHibernate.getById(debitRecord.getId(), DebitRecord.class).orElseGet(BudgetFactory::generateDebitRecord);

        assertAll(
                () -> assertEquals(debitRecord.getAmount(), retrievedRecord.getAmount()),
                () -> assertEquals(debitRecord.getDebitType(), retrievedRecord.getDebitType()),
                () -> assertEquals(debitRecord.getPaymentType(), retrievedRecord.getPaymentType()),
                () -> assertEquals(debitRecord.getDate(), retrievedRecord.getDate())
        );
    }

    @Test
    void validRecord_deleteById_recordDeleted() {
        DebitRecord debitRecord = BudgetFactory.generateDebitRecord();
        recordDaoHibernate.save(debitRecord);

        recordDaoHibernate.delete(debitRecord);

        assertTrue(recordDaoHibernate.getById(debitRecord.getId(), Record.class).isEmpty());
    }

    @Test
    void recordInvalidId_deleteById_recordIsNotDeleted() {
        DebitRecord debitRecord = BudgetFactory.generateDebitRecord();
        recordDaoHibernate.save(debitRecord);

        recordDaoHibernate.delete(BudgetFactory.generateIncomeRecord());

        assertTrue(recordDaoHibernate.getById(debitRecord.getId(), Record.class).isPresent());
    }
}