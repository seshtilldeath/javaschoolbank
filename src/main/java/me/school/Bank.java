package me.school;

import me.school.account.BaseBankAccount;
import me.school.persons.Owner;

public class Bank {
    public void run() {
        BaseBankAccount bankAccount = new BaseBankAccount(new Owner("Pepa", "Ripa"), "98237582935", 1000D);
    }
}