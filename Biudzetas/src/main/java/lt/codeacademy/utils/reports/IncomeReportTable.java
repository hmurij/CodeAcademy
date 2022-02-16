package lt.codeacademy.utils.reports;

import lt.codeacademy.model.PajamuIrasas;

import java.util.Arrays;

public class IncomeReportTable extends ReportTable<PajamuIrasas> {

    @Override
    String generateTableHeader() {
        return String.format(ReportTable.HEADER_FORMAT, "Suma", "Data", "Kategorija", "Pajamos banke", "Informacija");
    }

    @Override
    String generateTableBody(PajamuIrasas[] records) {
        StringBuilder body = new StringBuilder();

        for (PajamuIrasas pajamuIrasas : records) {
            String comment = pajamuIrasas.getPapildomaInfo();
            body.append(String.format(ReportTable.BODY_FORMAT,
                    pajamuIrasas.getSuma(),
                    String.format("%1$tY-%1$tb-%1$td", pajamuIrasas.getData()),
                    pajamuIrasas.getKategorija(),
                    pajamuIrasas.isPozymisArIBanka() ? "Taip" : "Ne",
                    comment.length() > 25 ? comment.substring(0, 25) + "..." : comment));
        }

        return body.toString();
    }

    @Override
    double calculateTotal(PajamuIrasas[] records) {
       return Arrays.stream(records).filter(PajamuIrasas::isPozymisArIBanka)
                .mapToDouble(PajamuIrasas::getSuma).sum();
    }
}
