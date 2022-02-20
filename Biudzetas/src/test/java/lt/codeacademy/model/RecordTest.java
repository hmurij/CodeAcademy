package lt.codeacademy.model;

import lt.codeacademy.factory.BudgetFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordTest {

    @Test
    void givenRecordObject_whenEquals_thenTrue() {
        Record record1 = BudgetFactory.generateIncomeRecord();
        IncomeRecord record2 = (IncomeRecord) record1;

        assertEquals(record1, record2);
    }

    @Test
    void givenTwoDifferentRecordObjects_whenEquals_thenFalse() {
        Record record1 = BudgetFactory.generateIncomeRecord();
        DebitRecord record2 = BudgetFactory.generateDebitRecord();

        assertNotEquals(record1, record2);
    }
}