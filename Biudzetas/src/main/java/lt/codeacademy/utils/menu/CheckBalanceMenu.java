package lt.codeacademy.utils.menu;

import lt.codeacademy.budget.Budget;

public class CheckBalanceMenu {

    /**
     * Prints balance of budget to console
     * @param budget balance to be printed for
     */
    public static void checkBalanceMenu(Budget budget) {
        String format = "%20s%9.2f\n";
        System.out.printf(format, "Is viso pajamu: ", budget.getTotalIncome());
        System.out.printf(format, "Is viso islaidu: ", budget.getTotalDebit());
        System.out.println("-".repeat(40));
        System.out.printf(format, "Biudzeto balansas: ", budget.getBalance());
        System.out.println();
    }
}
