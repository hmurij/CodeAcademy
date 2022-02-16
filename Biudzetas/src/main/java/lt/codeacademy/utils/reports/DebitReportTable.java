package lt.codeacademy.utils.reports;

import lt.codeacademy.model.IslaiduIrasas;

import java.util.Arrays;

public class DebitReportTable extends ReportTable<IslaiduIrasas> {
    @Override
    String generateTableHeader() {
        return String.format(ReportTable.HEADER_FORMAT, "Suma", "Data / laikas", "Kategorija", "Atsiskaitymo Budas", "Informacija");
    }

    @Override
    String generateTableBody(IslaiduIrasas[] records) {
        StringBuilder body = new StringBuilder();

        for (IslaiduIrasas islaiduIrasas : records) {
            String comment = islaiduIrasas.getPapildomaInfo();
            body.append(String.format(ReportTable.BODY_FORMAT,
                    islaiduIrasas.getSuma(),
                    String.format("%1$tY-%1$tb-%1$td %1$tH:%1$tM", islaiduIrasas.getDataSuLaiku()),
                    islaiduIrasas.getKategorija(),
                    islaiduIrasas.getAtsiskaitymoBudas(),
                    comment.length() > 25 ? comment.substring(0, 25) + "..." : comment));
        }

        return body.toString();
    }

    @Override
    double calculateTotal(IslaiduIrasas[] records) {
        return Arrays.stream(records).map(IslaiduIrasas::getSuma).mapToDouble(Double::doubleValue).sum();
    }
}
