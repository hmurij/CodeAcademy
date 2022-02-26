package lt.codeacademy.utils;

import lt.codeacademy.budget.Budget;
import lt.codeacademy.factory.BudgetFactory;
import lt.codeacademy.model.Record;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileUtilsTest {

    @Test
    void givenInvalidFilePath_whenReadBiudzetasFromFile_thenLengthZero() {
        String filePath = "data.dat";
        int expectedSize = 0;

        List<Record> records = FileUtils.readData(filePath);

        assertEquals(expectedSize, records.size());
    }

    @Test
    void givenValidFilePath_whenReadBiudzetasFromFile_thenReturnNull() {
        String filePath = "src/test/resources/testReadData.csv";
        int expectedSize = 20;

        List<Record> records = FileUtils.readData(filePath);

        assertEquals(expectedSize, records.size());
    }

    @Test
    void givenMockBiudzetasObject_whenSaveData_thenFileExistsFalseBeforeTrueAfter() {
        String filePath = "src/test/resources/testWriteData.csv";
        Budget budget = BudgetFactory.generateBudgetMockObject();
        File file = new File(filePath);

        boolean fileExistBeforeSaveData = file.exists();
        FileUtils.saveData(Stream.of(budget.getDebitRecords(), budget.getIncomeRecords())
                .flatMap(List::stream).collect(Collectors.toList()), filePath);
        boolean fileExistAfterSaveData = file.exists();
        boolean fileDeleted = file.delete();

        Assertions.assertAll(
                () -> assertFalse(fileExistBeforeSaveData),
                () -> assertTrue(fileExistAfterSaveData),
                () -> assertTrue(fileDeleted)
        );
    }
}