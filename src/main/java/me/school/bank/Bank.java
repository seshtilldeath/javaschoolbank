package me.school.bank;

import javax.inject.Inject;
import me.school.bank.account.*;
import me.school.bank.interest.InterestService;
import me.school.bank.moneyTransfer.MoneyTransferService;
import me.school.bank.persons.Owner;
import me.school.bank.persons.OwnerService;
import me.school.bank.print.PrintService;

import java.util.Map;

public class Bank {
    @Inject private MoneyTransferService moneyTransferService;
    @Inject private OwnerService ownerService;
    @Inject private InterestService interestService;
    @Inject private PrintService printService;
    @Inject private AccountService accountService;
    @Inject private JsonParser jsonParser;

    public Bank() {
    }

    public void run() throws Exception {
        Owner owner1 = this.ownerService.createAndSaveOwner("Vojta", "Lednice");
        Owner owner2 = this.ownerService.createAndSaveOwner("Michal", "Pospisil");

        BaseBankAccount bankAccount = this.accountService.createAndStoreNewBankAccount(owner1, 25000);
        SaveBankAccount savingBankAccount = this.accountService.createAndStoreNewSaveBankAccount(owner2, 25000);

        this.moneyTransferService.transferMoney(bankAccount, savingBankAccount, 2000);

        this.printService.debug("Money transfer");
        this.printService.printCurrentBankAccountBalance(bankAccount);
        this.printService.printCurrentBankAccountBalance(savingBankAccount);
        System.out.println();

        this.printService.debug("ATM");
        this.moneyTransferService.transferMoneyByATM(bankAccount, 100);
        this.printService.printCurrentBankAccountBalance(bankAccount);
        System.out.println();

        StudentBankAccount studentAccount = this.accountService.createAndStoreNewStudentBankAccount(owner1, 5000);

        this.moneyTransferService.transferMoney(studentAccount, savingBankAccount, 200);

        this.printService.debug("Student account transfer");
        this.printService.printCurrentBankAccountBalance(studentAccount);
        this.printService.printCurrentBankAccountBalance(savingBankAccount);
        System.out.println();

        this.printService.debug("Account list: interests start");
        for (Map.Entry<String, BaseBankAccount> entrySet : this.accountService.getAccounts().entrySet()) {
            BaseBankAccount account = entrySet.getValue();

            if (account instanceof InterestAccount) {
                this.printService.printCurrentBankAccountBalance(account);
                this.interestService.applyInterest(account);
                this.printService.printCurrentBankAccountBalance(account);
                System.out.println();
            }
        }
        this.printService.debug("Account list: interests end");

        String parsedOwner1 = jsonParser.toJson(owner1);
        String parsedOwner2 = jsonParser.toJson(owner2);
        System.out.println("JSON parser: ");
        System.out.println(parsedOwner1);
        System.out.println(parsedOwner2);
    }
}
