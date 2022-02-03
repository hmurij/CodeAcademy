package lt.codeacademy.exercise;

import lt.codeacademy.exercise.bank.data.LumiData;
import lt.codeacademy.exercise.bank.data.SepData;
import lt.codeacademy.exercise.bank.data.ShvedData;
import lt.codeacademy.exercise.menu.console.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lt.codeacademy.ConsolePrinter.print;

public class BankPaymentsApplication {

    private final ConsoleMenu mainMenu;
    private final ConsoleMenu bankReportMenu;
    private final ConsoleMenu filterByDateRangeMenu;
    private final ConsoleMenu filterByDateMenu;
    private final Set<Record> records;

    public BankPaymentsApplication() {
        this.mainMenu = new MainMenu();
        this.bankReportMenu = new BankReportMenu();
        this.filterByDateRangeMenu = new FilterByDateRangeMenu();
        this.filterByDateMenu = new FilterByDateMenu();

        this.records = new LinkedHashSet<>();
    }

    public void run() {

        String selectedOption;
        do {
            selectedOption = mainMenu.printAndRead();

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
                String bankName = bankReportMenu.printAndRead();
                print(generateBankReport(records.stream()
                        .filter(r -> r.getBankName().equals(bankName))
                        .collect(Collectors.toSet())));
                break;
            case "6":
                String dateRange = filterByDateRangeMenu.printAndRead();
                print(generateBankReport(filterByDateRange(dateRange)));
                break;
            case "7":
                String date = filterByDateMenu.printAndRead();
                print(generateBankReport(filterByDate(date)));
                break;

        }
    }

    /**
     * Filters bank records by date
     * @param date date as String object in format YYYY-MM-DD
     * @return filtered set of bank records
     */
    private Set<Record> filterByDate(String date) {
        Set<Record> recordsSet = Set.of();

        try{
            LocalDate localDate = LocalDate.parse(date);
//            recordsSet = records.stream().filter(r -> r.getDate().compareTo(localDate) == 0).collect(Collectors.toSet());
            recordsSet = records.stream().filter(r -> r.getDate().isEqual(localDate)).collect(Collectors.toSet());
        } catch (DateTimeParseException e){
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
    private Set<Record> filterByDateRange(String dateRange) {

        Set<Record> recordSet = Set.of();

        try {
            String[] dates = dateRange.split(" ");
            if (dates.length != 2) {
                throw new IllegalArgumentException();
            }
            LocalDate start = LocalDate.parse(dates[0]);
            LocalDate end = LocalDate.parse(dates[1]);

//            recordSet = records.stream().filter(r -> r.getDate().compareTo(start) >= 0 && r.getDate().compareTo(end) <= 0)
//                    .sorted(Comparator.comparing(Record::getDate)
//                            .reversed()).collect(Collectors.toCollection(LinkedHashSet::new));

            recordSet = records.stream().filter(r -> r.getDate().isAfter(start.minusDays(1))
                            && r.getDate().isBefore(end.plusDays(1)))
                    .sorted(Comparator.comparing(Record::getDate)
                            .reversed()).collect(Collectors.toCollection(LinkedHashSet::new));

        } catch (DateTimeParseException | IllegalArgumentException e) {
            print("Invalid date parameters");
        }

        return recordSet;
    }

    /**
     * Generates Bank payment report in table format
     *
     * @param records set of bank payment records
     * @return formatted string of bank payments
     */
    private String generateBankReport(Set<Record> records) {
//        * Datos formatas: YYYY-MM-DD
//        * Mokejimo sumos formatas: XXX.XX (su tasku)
//        * Ataskaitos forma: Eil. Nr., Data, Suma, Moketojas, Saskaitos Nr


        final String TOP_LEFT_CORNER = String.valueOf('\u2554');
        final String TOP_RIGHT_CORNER = String.valueOf('\u2557');
        final String BOTTOM_RIGHT_CORNER = String.valueOf('\u255D');
        final String BOTTOM_LEFT_CORNER = String.valueOf('\u255A');

        final String CROSS_JOINT = String.valueOf('\u256C');
        final String VERTICAL = String.valueOf('\u2551');
        final String HORIZONTAL = String.valueOf('\u2550');

        final String FROM_TOP_JOINT = String.valueOf('\u2566');
        final String FROM_BOTTOM_JOINT = String.valueOf('\u2569');
        final String FROM_LEFT_JOINT = String.valueOf('\u2560');
        final String FROM_RIGHT_JOINT = String.valueOf('\u2563');

        final String HEADER_BORDER = TOP_LEFT_CORNER +
                HORIZONTAL.repeat(6) +
                FROM_TOP_JOINT +
                HORIZONTAL.repeat(12) +
                FROM_TOP_JOINT +
                HORIZONTAL.repeat(12) +
                FROM_TOP_JOINT +
                HORIZONTAL.repeat(32) +
                FROM_TOP_JOINT +
                HORIZONTAL.repeat(32) +
                TOP_RIGHT_CORNER + "\n";

        final String MIDDLE_BORDER = FROM_LEFT_JOINT +
                HORIZONTAL.repeat(6) +
                CROSS_JOINT +
                HORIZONTAL.repeat(12) +
                CROSS_JOINT +
                HORIZONTAL.repeat(12) +
                CROSS_JOINT +
                HORIZONTAL.repeat(32) +
                CROSS_JOINT +
                HORIZONTAL.repeat(32) +
                FROM_RIGHT_JOINT + "\n";

        final String FOOTER_BORDER = BOTTOM_LEFT_CORNER +
                HORIZONTAL.repeat(6) +
                FROM_BOTTOM_JOINT +
                HORIZONTAL.repeat(12) +
                FROM_BOTTOM_JOINT +
                HORIZONTAL.repeat(12) +
                FROM_BOTTOM_JOINT +
                HORIZONTAL.repeat(32) +
                FROM_BOTTOM_JOINT +
                HORIZONTAL.repeat(32) +
                BOTTOM_RIGHT_CORNER + "\n";

        final String HEADER = VERTICAL +
                String.format(" %-4s ", "Nr") +
                VERTICAL +
                String.format(" %-10s ", "Date") +
                VERTICAL +
                String.format(" %-10s ", "Amount") +
                VERTICAL +
                String.format(" %-30s ", "Payer Name") +
                VERTICAL +
                String.format(" %-30s ", "Account Number") +
                VERTICAL + "\n";


        StringBuilder builder = new StringBuilder();
        builder.append(HEADER_BORDER);
        builder.append(HEADER);
        builder.append(MIDDLE_BORDER);

        Record[] ra = records.toArray(Record[]::new);
        for (int i = 0; i < records.size(); i++) {
            builder.append(VERTICAL)
                    .append(String.format(" %-4d ", i + 1))
                    .append(VERTICAL)
                    .append(String.format(" %10s ", String.format("%1$tY-%1$tm-%1$td", ra[i].getDate())))
                    .append(VERTICAL)
                    .append(String.format(" %-10.2f ", ra[i].getAmount()))
                    .append(VERTICAL)
                    .append(String.format(" %-30s ", ra[i].getPayerName()))
                    .append(VERTICAL)
                    .append(String.format(" %-30s ", ra[i].getAccountNr()))
                    .append(VERTICAL)
                    .append("\n");
        }
        builder.append(FOOTER_BORDER);

        return builder.toString();
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
            records.add(new Record("Lumi",
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
            records.add(new Record("Sep",
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
            records.add(new Record("Shved",
                    LocalDate.parse(data[i][0], formatter),
                    Double.parseDouble(data[i][2].replace(",", ".")),
                    "",
                    data[i][1]));
        }
    }
}

























