package me.school.moneytransfer;

import me.school.account.BaseBankAccount;
import me.school.account.StundentBankAccount;

import java.util.HashMap;
import java.util.Map;

public class Fee {
    public Map<Class<?>, Integer> map = new HashMap<>();

    public double addFee(double value, BaseBankAccount bankAccount) {
        System.out.println(map.get(bankAccount.getClass()));
        return value - (value > 1000 ? (value /100) : 0) - 0;
    }
}
