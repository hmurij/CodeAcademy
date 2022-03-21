package lt.codeacademy.factory;

import lt.codeacademy.budget.Budget;
import lt.codeacademy.budget.dao.RecordDaoHibernateImpl;
import lt.codeacademy.budget.entity.DebitRecord;
import lt.codeacademy.budget.entity.IncomeRecord;
import lt.codeacademy.budget.service.RecordServiceImpl;
import lt.codeacademy.type.DebitType;
import lt.codeacademy.type.IncomeType;
import lt.codeacademy.type.PaymentType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Factory class generated mock data for Budget object
 */
public class BudgetFactory {

    /**
     * Creates new Budget objects and populates it with generated data
     *
     * @return budget object with 10 records of DebitRecord and IncomeRecord objects
     */
    public static Budget generateBudgetMockObject() {
        Budget budget = new Budget(new RecordServiceImpl(new RecordDaoHibernateImpl()));
        Stream.of(
                        Stream.generate(BudgetFactory::generateDebitRecord).limit(10),
                        Stream.generate(BudgetFactory::generateIncomeRecord).limit(10)
                )
                .flatMap(record -> record)
                .forEach(budget::addRecord);
        return budget;
    }

    /**
     * Generates random DebitRecord object
     *
     * @return random DebitRecord object
     */
    public static DebitRecord generateDebitRecord() {
        Random r = new Random();
        DebitType[] debitTypes = DebitType.values();
        PaymentType[] paymentType = PaymentType.values();

        return new DebitRecord(
                r.nextDouble() * 1000,
                LocalDate.now().minusDays(r.nextInt(365)),
                LocalTime.now().minusMinutes(r.nextInt(60 * 24)),
                debitTypes[r.nextInt(debitTypes.length)],
                paymentType[r.nextInt(paymentType.length)],
                generateComment()
        );
    }

    /**
     * Generates random IncomeRecord object
     *
     * @return random IncomeRecord object
     */
    public static IncomeRecord generateIncomeRecord() {
        Random r = new Random();
        IncomeType[] incomeType = IncomeType.values();

        return new IncomeRecord(r.nextDouble() * 1000,
                LocalDate.now().minusDays(r.nextInt(365)),
                incomeType[r.nextInt(incomeType.length)],
                r.nextBoolean(),
                generateComment());
    }

    /**
     * Generates random dummy text comment
     *
     * @return random dummy text comment
     */
    private static String generateComment() {
        String[] comments = {"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa." +
                "Lorem ipsum dolor sit amet.", "Lorem ipsum dolor.", "Lorem ipsum dolor sit amet, consectetuer adipiscing.",
                "Lorem ipsum."};

        return comments[new Random().nextInt(comments.length)];
    }
}
