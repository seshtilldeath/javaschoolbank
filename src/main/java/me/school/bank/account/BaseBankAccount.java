package me.school.bank.account;

import me.school.bank.persons.Owner;

public class BaseBankAccount {
    protected Owner owner;

    protected String accountNumber;

    protected double balance;

    protected String organization;

    public BaseBankAccount(Owner owner, String accountNumber, double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public double getCurrentBalance() {
        return balance;
    }

    public void substractFromBalance(double amount) {
        this.balance -= amount;
    }

    public void addToBalance(double amount) {
        this.balance += amount;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setOrganization(String newOrganization) {
        this.organization = newOrganization;
    }
}
