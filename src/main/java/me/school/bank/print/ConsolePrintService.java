package me.school.bank.print;

import com.google.inject.Singleton;
import me.school.bank.account.BaseBankAccount;
import me.school.bank.account.SaveBankAccount;
import me.school.bank.account.StudentBankAccount;

@Singleton
public class ConsolePrintService implements PrintInterface {
    public void printCurrentBankAccountBalance(BaseBankAccount bankAccount) {
        System.out.println(this.getAccountPrefix(bankAccount) + "owner: " + bankAccount.getOwner().getFullName() + " balance: " + bankAccount.getCurrentBalance() + ", account number: " + bankAccount.getAccountNumber());
    }

    public void debug(String message) {
        System.out.println("DEBUG: " + message);
        System.out.println();
    }

    private String getAccountPrefix(BaseBankAccount baseBankAccount) {
        if (baseBankAccount instanceof StudentBankAccount) {
            return "student account";
        }
        if (baseBankAccount instanceof SaveBankAccount) {
            return "save account";
        }

        return "base account";
    }
}
