package me.school.bank.interest;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.school.bank.account.BaseBankAccount;

@Singleton
public class InterestCalculator {
    @Inject private InterestConfigLoader interestConfigLoader;

    public double calculateInterest(BaseBankAccount bankAccount) {
        double interest = this.interestConfigLoader.fetchInterestRate(bankAccount);

        return bankAccount.getCurrentBalance() * interest;
    }
}
