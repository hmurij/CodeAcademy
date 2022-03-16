package lt.codeacademy.utils.reports;

import lt.codeacademy.model.IncomeRecord;

import java.util.List;

public class IncomeReportTableConsole extends ReportTableConsole<IncomeRecord> {

    @Override
    String generateTableHeader() {
        return String.format(
                ReportTableConsole.HEADER_FORMAT,
                "Id",
                "Suma",
                "Data",
                "Kategorija",
                "Pajamos banke",
                "Informacija"
        );
    }

    @Override
    String generateTableBody(List<IncomeRecord> records) {
        StringBuilder body = new StringBuilder();

        for (IncomeRecord incomeRecord : records) {
            String comment = incomeRecord.getComments();
            body.append(
                    String.format(
                            ReportTableConsole.BODY_FORMAT,
                            incomeRecord.getId(),
                            incomeRecord.getAmount(),
                            String.format("%1$tY-%1$tb-%1$td", incomeRecord.getDate()),
                            incomeRecord.getIncomeType(),
                            incomeRecord.isIncomeReceived() ? "Taip" : "Ne",
                            comment.length() > 25 ? comment.substring(0, 25) + "..." : comment)
            );
        }
        return body.toString();
    }
}
