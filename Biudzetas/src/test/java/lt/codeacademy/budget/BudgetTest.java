package lt.codeacademy.budget;

import lt.codeacademy.factory.BudgetFactory;
import lt.codeacademy.model.DebitRecord;
import lt.codeacademy.model.IncomeRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {

    @Test
    void givenBudgetWithTwoRecords_whenGetBalance_thenTrue() {
        Budget budget = new Budget();
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
        Budget budget = new Budget();
        IncomeRecord incomeRecord = BudgetFactory.generateIncomeRecord();
        budget.addRecord(incomeRecord);
        double expectedBalance = incomeRecord.getAmount();

        double budgetBalance = budget.getBalance();

        assertEquals(expectedBalance, budgetBalance);
    }

    @Test
    void givenBudgetWithOneDebitRecord_whenGetBalance_thenTrue() {
        Budget budget = new Budget();
        DebitRecord debitRecord = BudgetFactory.generateDebitRecord();
        budget.addRecord(debitRecord);
        double expectedBalance = 0 - debitRecord.getAmount();

        double budgetBalance = budget.getBalance();

        assertEquals(expectedBalance, budgetBalance);
    }

    @Test
    void givenEmptyBudget_whenGetBalance_thenTrue() {
        Budget budget = new Budget();
        double expectedBalance = 0;

        double budgetBalance = budget.getBalance();

        assertEquals(expectedBalance, budgetBalance);
    }
}