package me.school.bank.account;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.school.bank.persons.Owner;

@Singleton
public class BankAccountFactory {
    @Inject private AccountNumberGenerator accountNumberGenerator;

    public BaseBankAccount createNewBaseBankAccount(Owner owner, double balance) {
        String generatedAccountNumber = this.accountNumberGenerator.generateUniqueNumber();

        return new BaseBankAccount(owner, generatedAccountNumber, balance);
    }

    public StudentBankAccount createNewStudentBankAccount(Owner owner, double balance) {
        String generatedAccountNumber = this.accountNumberGenerator.generateUniqueNumber();

        return new StudentBankAccount(owner, generatedAccountNumber, balance);
    }

    public SaveBankAccount createNewSaveBankAccount(Owner owner, double balance) {
        String generatedAccountNumber = this.accountNumberGenerator.generateUniqueNumber();

        return new SaveBankAccount(owner, generatedAccountNumber, balance);
    }
}