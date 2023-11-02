package me.school.bank.account;


import me.school.bank.persons.Owner;

public class StudentBankAccount extends BaseBankAccount implements InterestAccount {
    public StudentBankAccount(Owner owner, String bankAccountNumber, double balance) {
        super(owner, bankAccountNumber, balance);
    }
}
