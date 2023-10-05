package me.school.account;

import me.school.persons.Owner;

public class BaseBankAccount {
    private Owner owner;
    private String bankAccountNumber;
    private double balance;

    public BaseBankAccount(Owner owner, String bankAccountNumber, double balance) {
        this.owner = owner;
        this.bankAccountNumber = bankAccountNumber;
        this.balance = balance;
    }

    public double getBlanace() {
        return this.balance;
    }
    public void setBlanace(double value) {
        balance = value;
    }
}