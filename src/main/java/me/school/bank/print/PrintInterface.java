package me.school.bank.print;

import me.school.bank.account.BaseBankAccount;

public interface PrintInterface {
    public void printCurrentBankAccountBalance(BaseBankAccount bankAccount);
    public void debug(String message);
}
