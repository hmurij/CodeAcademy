package lt.codeacademy.exercise.service;

import lt.codeacademy.exercise.model.Record;

import java.util.Set;

public class ReportGenerator {
  private static final String TOP_LEFT_CORNER = String.valueOf('\u2554');
  private static final String TOP_RIGHT_CORNER = String.valueOf('\u2557');
  private static final String BOTTOM_RIGHT_CORNER = String.valueOf('\u255D');
  private static final String BOTTOM_LEFT_CORNER = String.valueOf('\u255A');

  private static final String CROSS_JOINT = String.valueOf('\u256C');
  private static final String VERTICAL = String.valueOf('\u2551');
  private static final String HORIZONTAL = String.valueOf('\u2550');

  private static final String FROM_TOP_JOINT = String.valueOf('\u2566');
  private static final String FROM_BOTTOM_JOINT = String.valueOf('\u2569');
  private static final String FROM_LEFT_JOINT = String.valueOf('\u2560');
  private static final String FROM_RIGHT_JOINT = String.valueOf('\u2563');

  /**
   * Generates Bank payment report in table format
   *
   * @param records set of bank payment records
   * @return formatted string of bank payments
   */
  public static String generateBankReport(Set<Record> records) {
    //        * Datos formatas: YYYY-MM-DD
    //        * Mokejimo sumos formatas: XXX.XX (su tasku)
    //        * Ataskaitos forma: Eil. Nr., Data, Suma, Moketojas, Saskaitos Nr

    return generateHeaderBorder()
        + generateHeader()
        + generateMiddleBorder()
        + generateBody(records.toArray(Record[]::new))
        + generateFooterBorder();
  }

  /**
   * Generates main body of the report
   *
   * @param recordsArray array of records
   * @return body of bank record table
   */
  private static String generateBody(Record[] recordsArray) {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < recordsArray.length; i++) {
      builder
          .append(VERTICAL)
          .append(String.format(" %-4d ", i + 1))
          .append(VERTICAL)
          .append(
              String.format(
                  " %10s ", String.format("%1$tY-%1$tm-%1$td", recordsArray[i].getDate())))
          .append(VERTICAL)
          .append(String.format(" %-10.2f ", recordsArray[i].getAmount()))
          .append(VERTICAL)
          .append(String.format(" %-30s ", recordsArray[i].getPayerName()))
          .append(VERTICAL)
          .append(String.format(" %-30s ", recordsArray[i].getAccountNr()))
          .append(VERTICAL)
          .append("\n");
    }

    return builder.toString();
  }

  /**
   * Generates header of bank records table
   *
   * @return header of the table
   */
  private static String generateHeader() {
    return VERTICAL
        + String.format(" %-4s ", "Nr")
        + VERTICAL
        + String.format(" %-10s ", "Date")
        + VERTICAL
        + String.format(" %-10s ", "Amount")
        + VERTICAL
        + String.format(" %-30s ", "Payer Name")
        + VERTICAL
        + String.format(" %-30s ", "Account Number")
        + VERTICAL
        + "\n";
  }

  /**
   * Generates footer border of bank records table
   *
   * @return footer of the table
   */
  private static String generateFooterBorder() {
    return BOTTOM_LEFT_CORNER
        + HORIZONTAL.repeat(6)
        + FROM_BOTTOM_JOINT
        + HORIZONTAL.repeat(12)
        + FROM_BOTTOM_JOINT
        + HORIZONTAL.repeat(12)
        + FROM_BOTTOM_JOINT
        + HORIZONTAL.repeat(32)
        + FROM_BOTTOM_JOINT
        + HORIZONTAL.repeat(32)
        + BOTTOM_RIGHT_CORNER
        + "\n";
  }

  /**
   * Generates middle border of bank records table
   *
   * @return middle border of the table
   */
  private static String generateMiddleBorder() {
    return FROM_LEFT_JOINT
        + HORIZONTAL.repeat(6)
        + CROSS_JOINT
        + HORIZONTAL.repeat(12)
        + CROSS_JOINT
        + HORIZONTAL.repeat(12)
        + CROSS_JOINT
        + HORIZONTAL.repeat(32)
        + CROSS_JOINT
        + HORIZONTAL.repeat(32)
        + FROM_RIGHT_JOINT
        + "\n";
  }

  /**
   * Generates header border of bank records table
   *
   * @return header of the table
   */
  private static String generateHeaderBorder() {
    return TOP_LEFT_CORNER
        + HORIZONTAL.repeat(6)
        + FROM_TOP_JOINT
        + HORIZONTAL.repeat(12)
        + FROM_TOP_JOINT
        + HORIZONTAL.repeat(12)
        + FROM_TOP_JOINT
        + HORIZONTAL.repeat(32)
        + FROM_TOP_JOINT
        + HORIZONTAL.repeat(32)
        + TOP_RIGHT_CORNER
        + "\n";
  }
}
