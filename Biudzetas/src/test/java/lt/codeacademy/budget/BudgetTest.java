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

        Optional<Record> foundRecord = budget.getRecordById(id, IncomeRecord.class);

        assertFalse(foundRecord.isPresent());
    }

    @Test
    void givenBudgetValidClass_whenGetRecordById_thenTureAndEquals() {
        Record record1 = BudgetFactory.generateIncomeRecord();
        Record record2 = BudgetFactory.generateDebitRecord();
        budget.addRecord(record1);
        budget.addRecord(record2);
        int id = record2.getId();

        Optional<Record> foundRecord = budget.getRecordById(id, DebitRecord.class);

        assertAll(
                () -> assertTrue(foundRecord.isPresent()),
                () -> assertEquals(foundRecord.get().getClass(), DebitRecord.class)
        );
    }
}