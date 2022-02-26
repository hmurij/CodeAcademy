package lt.codeacademy.budget;

import lt.codeacademy.factory.BudgetFactory;
import lt.codeacademy.model.DebitRecord;
import lt.codeacademy.model.IncomeRecord;
import lt.codeacademy.model.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BudgetTest {

    private Budget budget;

    @BeforeEach
    void setUp() {
        budget = new Budget();
    }

    @Test
    void givenBudgetWithTwoRecords_whenGetBalance_thenTrue() {
        IncomeRecord incomeRecord = BudgetFactory.generateIncomeRecord();
        DebitRecord debitRecord = BudgetFactory.generateDebitRecord();
        budget.addRecord(incomeRecord);
        budget.addRecord(debitRecord);
        double expectedBalance = incomeRecord.getAmount() - debitRecord.getAmount();

        double budgetBalance = budget.getBalance();

        assertEquals(expectedBalance, budgetBalance);
    }

    @Test
    void givenBudgetWithOneIncomeRecord_whenGetBalance_thenTrue() {
        IncomeRecord incomeRecord = BudgetFactory.generateIncomeRecord();
        budget.addRecord(incomeRecord);
        double expectedBalance = incomeRecord.getAmount();

        double budgetBalance = budget.getBalance();

        assertEquals(expectedBalance, budgetBalance);
    }

    @Test
    void givenBudgetWithOneDebitRecord_whenGetBalance_thenTrue() {
        DebitRecord debitRecord = BudgetFactory.generateDebitRecord();
        budget.addRecord(debitRecord);
        double expectedBalance = 0 - debitRecord.getAmount();

        double budgetBalance = budget.getBalance();

        assertEquals(expectedBalance, budgetBalance);
    }

    @Test
    void givenEmptyBudget_whenGetBalance_thenTrue() {
        double expectedBalance = 0;

        double budgetBalance = budget.getBalance();

        assertEquals(expectedBalance, budgetBalance);
    }

    @Test
    void givenBudgetValidId_whenGetRecordById_thenTrueAndEquals() {
        Record record1 = BudgetFactory.generateIncomeRecord();
        Record record2 = BudgetFactory.generateDebitRecord();
        budget.addRecord(record1);
        budget.addRecord(record2);
        int id = record1.getId();

        Optional<Record> foundRecord = budget.getRecordById(id, Record.class);

        assertTrue(foundRecord.isPresent());
    }

    @Test
    void givenBudgetInvalidId_whenGetRecordById_thenTrueAndEquals() {
        Record record1 = BudgetFactory.generateIncomeRecord();
        Record record2 = BudgetFactory.generateDebitRecord();
        budget.addRecord(record1);
        budget.addRecord(record2);
        int id = 100;

        Optional<Record> foundRecord = budget.getRecordById(id, Record.class);

        assertFalse(foundRecord.isPresent());
    }

    @Test
    void givenBudgetInvalidClass_whenGetRecordById_thenFalse() {
        Record record1 = BudgetFactory.generateIncomeRecord();
        Record record2 = BudgetFactory.generateDebitRecord();
        budget.addRecord(record1);
        budget.addRecord(record2);
        int id = record2.getId();

        Optional<IncomeRecord> foundRecord = budget.getRecordById(id, IncomeRecord.class);

        assertFalse(foundRecord.isPresent());
    }

    @Test
    void givenBudgetValidClass_whenGetRecordById_thenTureAndEquals() {
        Record record1 = BudgetFactory.generateIncomeRecord();
        Record record2 = BudgetFactory.generateDebitRecord();
        budget.addRecord(record1);
        budget.addRecord(record2);
        int id = record2.getId();

        Optional<DebitRecord> foundRecord = budget.getRecordById(id, DebitRecord.class);

        assertAll(
                () -> assertTrue(foundRecord.isPresent()),
                () -> assertEquals(foundRecord.get().getClass(), DebitRecord.class)
        );
    }

    @Test
    void givenBudgetWithOneRecord_editRecord_thenEqualsTrue(){
        Record record = BudgetFactory.generateIncomeRecord();
        Record editedRecord = BudgetFactory.generateIncomeRecord();
        budget.addRecord(record);
        record.setAmount(editedRecord.getAmount());
        record.setDate(editedRecord.getDate());
        record.setComments(editedRecord.getComments());

        budget.editRecord(record);

        Optional<Record> resultRecord = budget.getRecordById(record.getId(), Record.class);
        assertAll(
                () -> assertTrue(resultRecord.isPresent()),
                () -> assertEquals(editedRecord.getAmount(), resultRecord.get().getAmount()),
                () -> assertEquals(editedRecord.getDate(), resultRecord.get().getDate()),
                () -> assertEquals(editedRecord.getComments(), resultRecord.get().getComments())
        );
    }

    @Test
    void givenBudgetWithInvalidEditRecord_editRecord_thenEqualsFalse(){
        Record record = BudgetFactory.generateIncomeRecord();
        Record editedRecord = BudgetFactory.generateIncomeRecord();
        budget.addRecord(record);

        budget.editRecord(editedRecord);

        Optional<Record> resultRecord = budget.getRecordById(record.getId(), Record.class);
        assertAll(
                () -> assertTrue(resultRecord.isPresent()),
                () -> assertNotEquals(editedRecord.getAmount(), resultRecord.get().getAmount()),
                () -> assertNotEquals(editedRecord.getDate(), resultRecord.get().getDate()),
                () -> assertNotEquals(editedRecord.getComments(), resultRecord.get().getComments())
        );
    }

    @Test
    void givenBudgetWithOneRecord_whenDeleteRecord_thenTrue() {
        Record record = BudgetFactory.generateIncomeRecord();
        int id = record.getId();
        budget.addRecord(record);

        boolean isDeleted = budget.deleteRecord(id);

        assertTrue(isDeleted);
    }

    @Test
    void givenEmptyBudget_whenDeleteRecord_thenFalse() {
        Record record = BudgetFactory.generateIncomeRecord();
        int id = record.getId();

        boolean isDeleted = budget.deleteRecord(id);

        assertFalse(isDeleted);
    }
}