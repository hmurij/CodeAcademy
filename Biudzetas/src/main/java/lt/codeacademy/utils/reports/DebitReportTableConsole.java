package lt.codeacademy.utils.reports;

import lt.codeacademy.model.DebitRecord;

import java.util.List;

public class DebitReportTableConsole extends ReportTableConsole<DebitRecord> {
    @Override
    String generateTableHeader() {
        return String.format(
                ReportTableConsole.HEADER_FORMAT,
                "Id",
                "Suma",
                "Data / laikas",
                "Kategorija",
                "Atsiskaitymo Budas",
                "Informacija"
        );
    }

    @Override
    String generateTableBody(List<DebitRecord> records) {
        StringBuilder body = new StringBuilder();

        for (DebitRecord debitRecord : records) {
            String comment = debitRecord.getComments();
            body.append(
                    String.format(ReportTableConsole.BODY_FORMAT,
                    debitRecord.getId(),
                    debitRecord.getAmount(),
                    String.format("%s %2$tH:%2$tM", debitRecord.getDate(), debitRecord.getTime()),
                    debitRecord.getDebitType(),
                    debitRecord.getPaymentType(),
                    comment.length() > 25 ? comment.substring(0, 25) + "..." : comment));
        }

        return body.toString();
    }
}
