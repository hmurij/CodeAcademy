package lt.codeacademy.utils.mapper;

import lt.codeacademy.exception.RecordMapperException;
import lt.codeacademy.budget.entity.DebitRecord;
import lt.codeacademy.budget.entity.IncomeRecord;
import lt.codeacademy.budget.entity.Record;
import lt.codeacademy.type.DebitType;
import lt.codeacademy.type.IncomeType;
import lt.codeacademy.type.PaymentType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecordMapper {
    public static Record mapRecord(String csvRecord) {
        Record record;
        String recordType = csvRecord.substring(0, 1);
        switch (recordType) {
            case "D":
                record = mapDebitRecord(csvRecord.substring(2));
                break;
            case "I":
                record = mapIncomeRecord(csvRecord.substring(2));
                break;
            default:
                throw new RecordMapperException("Invalid data");
        }
        return record;
    }

    private static Record mapIncomeRecord(String csvRecord) {
        String[] data = csvRecord.split(",");
        return new IncomeRecord(
                Double.parseDouble(data[0]),
                LocalDate.parse(data[1]),
                IncomeType.valueOf(data[2]),
                data[3].equals("true"),
                data[4].split(" ").length > 1 ? data[4].replaceAll("^\"|\"$", "") : data[4]
        );
    }

    private static Record mapDebitRecord(String csvRecord) {
        String[] data = csvRecord.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dataTime = LocalDateTime.parse(data[1], formatter);
        return new DebitRecord(
                Double.parseDouble(data[0]),
                dataTime.toLocalDate(),
                dataTime.toLocalTime(),
                DebitType.valueOf(data[2]),
                PaymentType.valueOf(data[3]),
                data[4].split(" ").length > 1 ? data[4].replaceAll("^\"|\"$", "") : data[4]
        );
    }
}
