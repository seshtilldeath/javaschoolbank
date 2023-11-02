package me.school.bank.moneyTransfer.fee;

import com.google.inject.Singleton;
import me.school.bank.account.BaseBankAccount;
import me.school.bank.account.SaveBankAccount;
import me.school.bank.account.StudentBankAccount;

@Singleton
public class FeeConfigurationLoader {
    private static final double DEFAULT_PERCENT_FEE_LIMIT = 1000;
    private static final double DEFAULT_BASE_FEE = 5;
    private static final double DEFAULT_BASE_PERCENT = 5;

    private static final double SAVING_ACCOUNT_PERCENT_FEE_LIMIT = 500;
    private static final double SAVING_ACCOUNT_BASE_FEE = 50;
    private static final double SAVING_ACCOUNT_BASE_PERCENT = 15;

    public FeeConfigurator loadFeeConfig(BaseBankAccount account) {
        if (account instanceof StudentBankAccount) {
            return new FeeConfigurator();
        }

        if (account instanceof SaveBankAccount) {
            return new FeeConfigurator(SAVING_ACCOUNT_BASE_FEE, SAVING_ACCOUNT_PERCENT_FEE_LIMIT, SAVING_ACCOUNT_BASE_PERCENT);
        }

        return new FeeConfigurator(DEFAULT_BASE_FEE, DEFAULT_PERCENT_FEE_LIMIT, DEFAULT_BASE_PERCENT);
    }
}
