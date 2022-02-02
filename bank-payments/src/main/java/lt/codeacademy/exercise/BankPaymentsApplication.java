package lt.codeacademy.exercise;

import lt.codeacademy.ConsolePrinter;
import lt.codeacademy.exercise.bank.data.LumiData;
import lt.codeacademy.exercise.menu.console.ConsoleMenu;
import lt.codeacademy.exercise.menu.console.MainMenu;

import java.time.LocalDate;
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
                readLumiData();
                ConsolePrinter.print("Reading formatted \"LumiData\" payments");
                break;
            case "2":
                ConsolePrinter.print("Reading formatted \"SepData\" payments");
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
    private void readLumiData(){
        // Debtor name, Payment date, IBAN, Amount
        // "Karlson und Meier KG", "2022-0-14", "DE16333333330000002222", "10.12"

//        private LocalDate date;
//        private double amount;
//        private String payerName;
//        private String accountNr;

        for(int i = 1; i < LumiData.MOCK_DATA.length; i++){
            records.add(new Record(LocalDate.parse(LumiData.MOCK_DATA[i][1]),
                    Double.parseDouble(LumiData.MOCK_DATA[i][3]),
                    LumiData.MOCK_DATA[i][0],
                    LumiData.MOCK_DATA[i][2]));
        }

//        records.forEach(System.out::println);
    }
}
