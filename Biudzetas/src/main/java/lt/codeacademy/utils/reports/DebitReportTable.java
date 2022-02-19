package lt.codeacademy.utils.reports;

import lt.codeacademy.model.DebitRecord;

import java.util.Arrays;

public class DebitReportTable extends ReportTable<DebitRecord> {
    @Override
    String generateTableHeader() {
        return String.format(ReportTable.HEADER_FORMAT, "Suma", "Data / laikas", "Kategorija", "Atsiskaitymo Budas", "Informacija");
    }

    @Override
    String generateTableBody(DebitRecord[] records) {
        StringBuilder body = new StringBuilder();

        for (DebitRecord debitRecord : records) {
            String comment = debitRecord.getComments();
            body.append(String.format(ReportTable.BODY_FORMAT,
                    debitRecord.getAmount(),
                    String.format("%1$tY-%1$tb-%1$td %1$tH:%1$tM", debitRecord.getDateTime()),
                    debitRecord.getDebitType(),
                    debitRecord.getPaymentType(),
                    comment.length() > 25 ? comment.substring(0, 25) + "..." : comment));
        }

        return body.toString();
    }

    @Override
    double calculateTotal(DebitRecord[] records) {
        return Arrays.stream(records).map(DebitRecord::getAmount).mapToDouble(Double::doubleValue).sum();
    }
}
