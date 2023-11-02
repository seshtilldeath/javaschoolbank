package me.school.bank.account;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.school.bank.persons.Owner;
import me.school.bank.print.PrintService;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class AccountService {
    @Inject private BankAccountFactory bankAccountFactory;
    @Inject private PrintService printService;

    private Map<String, BaseBankAccount> accounts;

    public AccountService() {
        this.accounts = new HashMap<>();
    }

    public BaseBankAccount createAndStoreNewBankAccount(Owner owner, float balance) {
        BaseBankAccount bankAccount = this.bankAccountFactory.createNewBaseBankAccount(owner, balance);
        this.accounts.put(bankAccount.getAccountNumber(), bankAccount);
        this.printService.printCurrentBankAccountBalance(bankAccount);

        bankAccount.setOrganization("CSOB");

        return bankAccount;
    }

    public StudentBankAccount createAndStoreNewStudentBankAccount(Owner owner, float balance) {
        StudentBankAccount studentAccount = this.bankAccountFactory.createNewStudentBankAccount(owner, balance);
        this.accounts.put(studentAccount.getAccountNumber(), studentAccount);
        this.printService.printCurrentBankAccountBalance(studentAccount);

        return studentAccount;
    }

    public SaveBankAccount createAndStoreNewSaveBankAccount(Owner owner, float balance) {
        SaveBankAccount saveAccount = this.bankAccountFactory.createNewSaveBankAccount(owner, balance);
        this.accounts.put(saveAccount.getAccountNumber(), saveAccount);
        this.printService.printCurrentBankAccountBalance(saveAccount);

        return saveAccount;
    }

    public Map<String, BaseBankAccount> getAccounts() {
        return accounts;
    }
}
