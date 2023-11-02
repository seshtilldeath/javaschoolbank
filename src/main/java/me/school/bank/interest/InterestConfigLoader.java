package me.school.bank.interest;

import com.google.inject.Singleton;
import me.school.bank.account.BaseBankAccount;
import me.school.bank.account.SaveBankAccount;
import me.school.bank.account.StudentBankAccount;

@Singleton
public class InterestConfigLoader {
    private static final double SAVING_ACCOUNT_INTEREST_RATE = 0.005;
    private static final double STUDENT_ACCOUNT_INTEREST_RATE = 0.001;

    public double fetchInterestRate(BaseBankAccount account) {
        if (account instanceof SaveBankAccount) {
            return SAVING_ACCOUNT_INTEREST_RATE;
        }

        if (account instanceof StudentBankAccount) {
            return STUDENT_ACCOUNT_INTEREST_RATE;
        }

        return 0;
    }
}
