package lt.codeacademy.exercise;

import lt.codeacademy.exercise.bank.data.LumiData;
import lt.codeacademy.exercise.bank.data.SepData;
import lt.codeacademy.exercise.bank.data.ShvedData;
import lt.codeacademy.exercise.menu.console.BankReportMenu;
import lt.codeacademy.exercise.menu.console.ConsoleMenu;
import lt.codeacademy.exercise.menu.console.FilterByDateMenu;
import lt.codeacademy.exercise.menu.console.FilterByDateRangeMenu;
import lt.codeacademy.exercise.menu.console.MainMenu;
import lt.codeacademy.exercise.model.Record;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;

import static lt.codeacademy.ConsolePrinter.print;
import static lt.codeacademy.exercise.service.BankRecordsFilter.filterByBankName;
import static lt.codeacademy.exercise.service.BankRecordsFilter.filterByDate;
import static lt.codeacademy.exercise.service.BankRecordsFilter.filterByDateRange;
import static lt.codeacademy.exercise.service.ReportGenerator.generateBankReport;

public class BankPaymentsApplication {

  private final ConsoleMenu MAIN_MENU;
  private final ConsoleMenu BANK_REPORT_MENU;
  private final ConsoleMenu FILTER_BY_DATE_RANGE_MENU;
  private final ConsoleMenu FILTER_BY_DATE_MENU;
  private final Set<Record> records;

  public BankPaymentsApplication() {
    this.MAIN_MENU = new MainMenu();
    this.BANK_REPORT_MENU = new BankReportMenu();
    this.FILTER_BY_DATE_RANGE_MENU = new FilterByDateRangeMenu();
    this.FILTER_BY_DATE_MENU = new FilterByDateMenu();

    this.records = new LinkedHashSet<>();
  }

  public void run() {

    String selectedOption;
    do {
      selectedOption = MAIN_MENU.printAndRead();

      if (!selectedOption.equals("0")) {
        processInput(selectedOption);
      }
    } while (!selectedOption.equals("0"));
  }

  /**
   * Processes user input
   *
   * @param selectedOption user input
   */
  private void processInput(String selectedOption) {
    print("Selected option: " + selectedOption);
    switch (selectedOption) {
      case "1":
        readLumiData(LumiData.MOCK_DATA);
        print("Reading formatted \"LumiData\" payments");
        break;
      case "2":
        readSepData(SepData.MOCK_DATA);
        print("Reading formatted \"SepData\" payments");
        break;
      case "3":
        readSvedData(ShvedData.MOCK_DATA);
        print("Reading formatted \"ShvedData\" payments");
        break;
      case "4":
        print(generateBankReport(records));
        break;
      case "5":
        String bankName = BANK_REPORT_MENU.printAndRead();
        print(generateBankReport(filterByBankName(bankName, records)));
        break;
      case "6":
        String dateRange = FILTER_BY_DATE_RANGE_MENU.printAndRead();
        print(generateBankReport(filterByDateRange(dateRange, records)));
        break;
      case "7":
        String date = FILTER_BY_DATE_MENU.printAndRead();
        print(generateBankReport(filterByDate(date, records)));
        break;
      default:
        print("Invalid date parameter");
        break;
    }
  }

  /**
   * Reads Lumi bank data and populates bank records
   *
   * @param data Lumi bank data
   */
  private void readLumiData(String[][] data) {
    // Debtor name, Payment date, IBAN, Amount
    // "Karlson und Meier KG", "2022-0-14", "DE16333333330000002222", "10.12"

    for (int i = 1; i < data.length; i++) {
      records.add(
          new Record(
              "Lumi",
              LocalDate.parse(data[i][1]),
              Double.parseDouble(data[i][3]),
              data[i][0],
              data[i][2]));
    }
  }

  /**
   * Reads Seb bank data and populates bank records
   *
   * @param data Sep bank data
   */
  private void readSepData(String[][] data) {
    // "Operation Date", "Payer Name", "IBAN", "Amount"
    // "04.01.2022", "Simpson S", "SP60123456781234567891", "431.00"

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    for (int i = 1; i < data.length; i++) {
      records.add(
          new Record(
              "Sep",
              LocalDate.parse(data[i][0], formatter),
              Double.parseDouble(data[i][3]),
              data[i][1],
              data[i][2]));
    }
  }

  /**
   * Reads Shved bank data and populates bank records
   *
   * @param data Sep bank data
   */
  private void readSvedData(String[][] data) {
    // "Execution date", "IBAN", "Paid Amount"
    // "02.01.2022", "LT16333333330000002222", "10,12"

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    for (int i = 1; i < data.length; i++) {
      records.add(
          new Record(
              "Shved",
              LocalDate.parse(data[i][0], formatter),
              Double.parseDouble(data[i][2].replace(",", ".")),
              "",
              data[i][1]));
    }
  }
}
