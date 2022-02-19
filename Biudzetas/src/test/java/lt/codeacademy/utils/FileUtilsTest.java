package lt.codeacademy.utils;

import lt.codeacademy.factory.BudgetFactory;
import lt.codeacademy.budget.Budget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileUtilsTest {

    @Test
    void givenInvalidFilePath_whenReadBiudzetasFromFile_thenLengthZero() {
        String filePath = "data.dat";
        int expectedIslaiduIrasuLength = 0;
        int expectedPajamuIrasuLength = 0;

        Budget budget = FileUtils.readBudgetFromFile(filePath);

        assertAll(
                () -> Assertions.assertEquals(expectedIslaiduIrasuLength, budget.getDebitRecords().length),
                () -> Assertions.assertEquals(expectedPajamuIrasuLength, budget.getIncomeRecords().length)
        );
    }

    @Test
    void givenValidFilePath_whenReadBiudzetasFromFile_thenReturnNull() {
        String filePath = "src/test/resources/testReadData.dat";
        int expectedIslaiduIrasuLength = 10;
        int expectedPajamuIrasuLength = 10;

        Budget budget = FileUtils.readBudgetFromFile(filePath);

        assertAll(
                () -> Assertions.assertEquals(expectedIslaiduIrasuLength, budget.getDebitRecords().length),
                () -> Assertions.assertEquals(expectedPajamuIrasuLength, budget.getIncomeRecords().length)
        );

    }

    @Test
    void givenMockBiudzetasObject_whenSaveBiudzetasToFile_thenFileExistsFalseBeforeTrueAfter() {
        String filePath = "src/test/resources/testWriteData.dat";
        Budget budget = BudgetFactory.generateBudgetMockObject();
        File file = new File(filePath);

        boolean fileExistBeforeSaveBiudzetasToFile = file.exists();
        FileUtils.saveBudgetToFile(budget, filePath);
        boolean fileExistAfterSaveBiudzetasToFile = file.exists();
        boolean fileDeleted = file.delete();

        Assertions.assertAll(
                () -> assertFalse(fileExistBeforeSaveBiudzetasToFile),
                () -> assertTrue(fileExistAfterSaveBiudzetasToFile),
                () -> assertTrue(fileDeleted)
        );


    }
}