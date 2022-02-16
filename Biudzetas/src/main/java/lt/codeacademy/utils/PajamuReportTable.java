package lt.codeacademy.utils;

import lt.codeacademy.model.PajamuIrasas;

import java.util.Arrays;

/**
 * Utility class to generate and print PajamuIrasas report table
 */
public class PajamuReportTable {
    private static final String SEPARATOR = "+" + "-".repeat(11) + "+" + "-".repeat(21) + "+" + "-".repeat(16)
            + "+" + "-".repeat(21) + "+" + "-".repeat(31) + "+\n";

    private PajamuReportTable() {
    }

    public static void printPajamuTable(PajamuIrasas[] pajamuIrasai) {
        System.out.println(generatePajamuIrasasTable(pajamuIrasai));
    }

    private static String generatePajamuIrasasTable(PajamuIrasas[] pajamuIrasai) {
        return SEPARATOR +
                generateTableHeader() +
                SEPARATOR +
                generateTableBody(pajamuIrasai) +
                SEPARATOR +
                generateFooter(pajamuIrasai);
    }

    private static String generateTableHeader() {
        String format = "| %-10s| %-20s| %-15s| %-20s| %-30s|\n";

        return String.format(format, "Suma", "Data", "Kategorija", "Pajamos banke", "Informacija");
    }

    private static String generateTableBody(PajamuIrasas[] pajamuIrasai) {
        String format = "| %-10.2f| %-20s| %-15s| %-20s| %-30s|\n";
        StringBuilder body = new StringBuilder();

        for (PajamuIrasas pajamuIrasas : pajamuIrasai) {
            String comment = pajamuIrasas.getPapildomaInfo();
            body.append(String.format(format,
                    pajamuIrasas.getSuma(),
                    String.format("%1$tY-%1$tb-%1$td", pajamuIrasas.getData()),
                    pajamuIrasas.getKategorija(),
                    pajamuIrasas.isPozymisArIBanka() ? "Taip" : "Ne",
                    comment.length() > 25 ? comment.substring(0, 25) + "..." : comment));
        }

        return body.toString();
    }

    private static String generateFooter(PajamuIrasas[] pajamuIrasai) {
        return String.format("Is viso: %5.2f\n", calculateTotal(pajamuIrasai));
    }

    private static double calculateTotal(PajamuIrasas[] pajamuIrasai) {
        return Arrays.stream(pajamuIrasai).filter(PajamuIrasas::isPozymisArIBanka)
                .mapToDouble(PajamuIrasas::getSuma).sum();
    }
}
