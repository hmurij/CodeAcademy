package lt.codeacademy.exercise.service;

import lt.codeacademy.exercise.model.Record;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lt.codeacademy.ConsolePrinter.print;

public class BankRecordsFilter {

  /**
   * Filters bank records by date
   *
   * @param date date as String object in format YYYY-MM-DD
   * @return filtered set of bank records
   */
  public static Set<Record> filterByDate(String date, Set<Record> records) {
    Set<Record> recordsSet = Set.of();

    try {
      LocalDate localDate = LocalDate.parse(date);
      recordsSet =
          records.stream().filter(r -> r.getDate().isEqual(localDate)).collect(Collectors.toSet());
    } catch (DateTimeParseException e) {
      print("Invalid date parameters");
    }

    return recordsSet;
  }

  /**
   * Filters bank records by date range
   *
   * @param dateRange date range as String object
   * @return filtered set of bank records
   */
  public static Set<Record> filterByDateRange(String dateRange, Set<Record> records) {

    Set<Record> recordSet = Set.of();

    try {
      String[] dates = dateRange.split(" ");
      if (dates.length != 2) {
        throw new IllegalArgumentException();
      }
      LocalDate start = LocalDate.parse(dates[0]);
      LocalDate end = LocalDate.parse(dates[1]);

      recordSet =
          records.stream()
              .filter(
                  r ->
                      r.getDate().isAfter(start.minusDays(1))
                          && r.getDate().isBefore(end.plusDays(1)))
              .sorted(Comparator.comparing(Record::getDate).reversed())
              .collect(Collectors.toCollection(LinkedHashSet::new));

    } catch (DateTimeParseException | IllegalArgumentException e) {
      print("Invalid date parameters");
    }

    return recordSet;
  }

  public static Set<Record> filterByBankName(String bankName, Set<Record> records) {
    return records.stream()
        .filter(r -> r.getBankName().equals(bankName))
        .collect(Collectors.toSet());
  }
}
