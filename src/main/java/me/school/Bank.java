package me.school;

import me.school.account.BaseBankAccount;
import me.school.account.StundentBankAccount;
import me.school.moneytransfer.Fee;
import me.school.moneytransfer.MoneyTransfer;
import me.school.persons.Owner;

import java.util.List;

public class Bank {
    //public static List<BaseBankAccount> bankAccounts;

    public void run() throws Exception {
        StundentBankAccount bankAccount = new StundentBankAccount(new Owner("Pepa", "Ripa"), "98237582935", 1000D);
        BaseBankAccount bankAccount2 = new BaseBankAccount(new Owner("Honza", "Komin"), "98237582935", 1000D);

        MoneyTransfer moneyTransfer = new MoneyTransfer();
        moneyTransfer.transferMoney(bankAccount, bankAccount2, 500D);
        moneyTransfer.transferMoney(bankAccount2, bankAccount, 500D);
    }
}