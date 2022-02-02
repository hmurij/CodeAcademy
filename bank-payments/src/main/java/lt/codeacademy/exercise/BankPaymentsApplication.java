package lt.codeacademy.exercise;

import lt.codeacademy.ConsolePrinter;
import lt.codeacademy.exercise.bank.data.LumiData;
import lt.codeacademy.exercise.bank.data.SepData;
import lt.codeacademy.exercise.menu.console.ConsoleMenu;
import lt.codeacademy.exercise.menu.console.MainMenu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class BankPaymentsApplication {

    private final ConsoleMenu mainMenu;
    private final Set<Record> records;

    public BankPaymentsApplication() {
        this.mainMenu = new MainMenu();
        this.records = new HashSet<>();
    }

    public void run() {

        String selectedOption;
        do {
            selectedOption = mainMenu.printAndRead();

            if(!selectedOption.equals("0")) {
                processInput(selectedOption);
            }
        } while (!selectedOption.equals("0") );
    }

    /**
     * Processes user input
     * @param selectedOption user input
     */
    private void processInput(String selectedOption) {
        ConsolePrinter.print("Selected option: " + selectedOption);
        switch (selectedOption) {
            case "1":
                readLumiData(LumiData.MOCK_DATA);
//                ConsolePrinter.print("Reading formatted \"LumiData\" payments");
                break;
            case "2":
                readSepData(SepData.MOCK_DATA);
//                ConsolePrinter.print("Reading formatted \"SepData\" payments");
                break;
            case "3":
                ConsolePrinter.print("Reading formatted \"ShvedData\" payments");
                break;
            case "4":
                ConsolePrinter.print("Showing all banks payments (as table)");
                break;
        }
    }

    /**
     * Reads Lumi bank data and populates bank records
     */
    private void readLumiData(String [][] data){
        // Debtor name, Payment date, IBAN, Amount
        // "Karlson und Meier KG", "2022-0-14", "DE16333333330000002222", "10.12"

        for(int i = 1; i < data.length; i++){
            records.add(new Record(LocalDate.parse(data[i][1]),
                    Double.parseDouble(data[i][3]),
                    data[i][0],
                    data[i][2]));
        }

//        records.forEach(System.out::println);
    }

    private void readSepData(String [][] data){
        // "Operation Date", "Payer Name", "IBAN", "Amount"
        // "04.01.2022", "Simpson S", "SP60123456781234567891", "431.00"

//        private LocalDate date;
//        private double amount;
//        private String payerName;
//        private String accountNr;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        for(int i = 1; i < data.length; i++){
            records.add(new Record(LocalDate.parse(data[i][0], formatter),
                    Double.parseDouble(data[i][3]),
                    data[i][1],
                    data[i][2]));
        }

//        records.forEach(System.out::println);

    }
}
