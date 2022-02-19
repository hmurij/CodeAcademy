package lt.codeacademy.utils.reports;

import lt.codeacademy.model.IncomeRecord;

import java.util.Arrays;

public class IncomeReportTable extends ReportTable<IncomeRecord> {

    @Override
    String generateTableHeader() {
        return String.format(ReportTable.HEADER_FORMAT, "Suma", "Data", "Kategorija", "Pajamos banke", "Informacija");
    }

    @Override
    String generateTableBody(IncomeRecord[] records) {
        StringBuilder body = new StringBuilder();

        for (IncomeRecord incomeRecord : records) {
            String comment = incomeRecord.getComments();
            body.append(
                    String.format(ReportTable.BODY_FORMAT,
                    incomeRecord.getAmount(),
                    String.format("%1$tY-%1$tb-%1$td", incomeRecord.getDate()),
                    incomeRecord.getIncomeType(),
                    incomeRecord.isIncomeReceived() ? "Taip" : "Ne",
                    comment.length() > 25 ? comment.substring(0, 25) + "..." : comment)
            );
        }

        return body.toString();
    }

    @Override
    double calculateTotal(IncomeRecord[] records) {
       return Arrays.stream(records).filter(IncomeRecord::isIncomeReceived)
                .mapToDouble(IncomeRecord::getAmount).sum();
    }
}
