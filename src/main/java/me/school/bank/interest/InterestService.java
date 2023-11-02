package me.school.bank.interest;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.school.bank.account.BaseBankAccount;

@Singleton
public class InterestService {
    @Inject private InterestCalculator interestCalculator;

    public void applyInterest(BaseBankAccount account) {
        double interestAmount = this.interestCalculator.calculateInterest(account);

        System.out.println("Interest Amount: " + interestAmount);

        account.addToBalance(interestAmount);
    }

}