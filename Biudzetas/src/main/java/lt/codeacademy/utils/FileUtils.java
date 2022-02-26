package lt.codeacademy.utils;

import lt.codeacademy.budget.Budget;
import lt.codeacademy.exception.RecordMapperException;
import lt.codeacademy.model.Record;
import lt.codeacademy.utils.mapper.RecordMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for saving and reading Budget object from file
 */
public class FileUtils {
    private final static String HEADER = "\"Record type\",Amount,Date/time,Type,Type,Comments\n";

    /**
     * Reads {@link Budget} object from file Data/data.dat
     */
    public static List<Record> readData(String filePath) {
        List<Record> records = List.of();
        try {
            List<String> data = Files.readAllLines(Path.of(filePath));
            records = data.subList(1, data.size()).stream().map(RecordMapper::mapRecord).collect(Collectors.toList());
        } catch (IllegalArgumentException | DateTimeParseException | RecordMapperException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Nerastas failas: " + filePath);
        }
        return records;
    }

    /**
     * Writes list of records to file
     *
     * @param records  list of records
     * @param filePath file path
     */
    public static void saveData(List<Record> records, String filePath) {
        try {
            Files.writeString(Path.of(filePath), generateCsvData(records), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String generateCsvData(List<Record> records) {
        StringBuilder data = new StringBuilder();
        data.append(HEADER);
        records.forEach(r -> data.append(r.toCsvString()));
        return data.toString();
    }
}
