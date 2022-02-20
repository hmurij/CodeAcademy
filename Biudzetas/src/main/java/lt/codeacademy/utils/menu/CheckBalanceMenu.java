package lt.codeacademy.utils.menu;

import lt.codeacademy.budget.Budget;

public class CheckBalanceMenu {
    public void checkBalance(Budget budget) {
        String format = "%20s%9.2f\n";
        System.out.printf(format, "Is viso pajamu: ", budget.getTotalIncome());
        System.out.printf(format, "Is viso islaidu: ", budget.getTotalDebit());
        System.out.println("-".repeat(40));
        System.out.printf(format, "Biudzeto balansas: ", budget.getBalance());
        System.out.println();
    }
}
