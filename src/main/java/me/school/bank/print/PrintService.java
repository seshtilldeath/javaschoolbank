package me.school.bank.print;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.school.bank.account.BaseBankAccount;

@Singleton
public class PrintService {
    @Inject private PrintInterface printService;

    public void printCurrentBankAccountBalance(BaseBankAccount bankAccount) {
        this.printService.printCurrentBankAccountBalance(bankAccount);
    }

    public void debug(String message) {
        this.printService.debug(message);
    }
}