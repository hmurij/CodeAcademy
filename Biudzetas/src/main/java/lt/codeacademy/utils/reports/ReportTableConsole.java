package lt.codeacademy.utils.reports;

import java.util.List;

public abstract class ReportTableConsole<T> {
    static final String SEPARATOR = "+" + "-".repeat(4) + "+" + "-".repeat(11) + "+" + "-".repeat(21)
            + "+" + "-".repeat(16) + "+" + "-".repeat(21) + "+" + "-".repeat(31) + "+\n";
    static final String HEADER_FORMAT = "| %-3s| %-10s| %-20s| %-15s| %-20s| %-30s|\n";
    static final String BODY_FORMAT = "| %-3d|%10.2f | %-20s| %-15s| %-20s| %-30s|\n";

    public void printTable(List<T> records) {
        System.out.println(generateTable(records));
    }

    private String generateTable(List<T> records) {
        return SEPARATOR +
                generateTableHeader() +
                SEPARATOR +
                generateTableBody(records) +
                SEPARATOR;
    }

    abstract String generateTableHeader();

    abstract String generateTableBody(List<T> records);
}
