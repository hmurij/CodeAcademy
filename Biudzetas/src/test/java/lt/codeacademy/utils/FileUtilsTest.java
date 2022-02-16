package lt.codeacademy.utils;

import lt.codeacademy.factory.BiudzetasFactory;
import lt.codeacademy.model.Biudzetas;
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

        Biudzetas biudzetas = FileUtils.readBiudzetasFromFile(filePath);

        assertAll(
                () -> Assertions.assertEquals(expectedIslaiduIrasuLength, biudzetas.gautiIslaiduIrasus().length),
                () -> Assertions.assertEquals(expectedPajamuIrasuLength, biudzetas.gautiPajamuIrasus().length)
        );
    }

    @Test
    void givenValidFilePath_whenReadBiudzetasFromFile_thenReturnNull() {
        String filePath = "src/test/resources/testReadData.dat";
        int expectedIslaiduIrasuLength = 10;
        int expectedPajamuIrasuLength = 10;

        Biudzetas biudzetas = FileUtils.readBiudzetasFromFile(filePath);

        assertAll(
                () -> Assertions.assertEquals(expectedIslaiduIrasuLength, biudzetas.gautiIslaiduIrasus().length),
                () -> Assertions.assertEquals(expectedPajamuIrasuLength, biudzetas.gautiPajamuIrasus().length)
        );

    }

    @Test
    void givenMockBiudzetasObject_whenSaveBiudzetasToFile_thenFileExistsFalseBeforeTrueAfter() {
        String filePath = "src/test/resources/testWriteData.dat";
        Biudzetas biudzetas = BiudzetasFactory.generateBiudzetasMockObject();
        File file = new File(filePath);

        boolean fileExistBeforeSaveBiudzetasToFile = file.exists();
        FileUtils.saveBiudzetasToFile(biudzetas, filePath);
        boolean fileExistAfterSaveBiudzetasToFile = file.exists();
        boolean fileDeleted = file.delete();

        Assertions.assertAll(
                () -> assertFalse(fileExistBeforeSaveBiudzetasToFile),
                () -> assertTrue(fileExistAfterSaveBiudzetasToFile),
                () -> assertTrue(fileDeleted)
        );


    }
}