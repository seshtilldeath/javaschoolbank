package me.school.bank.moneyTransfer;

import com.google.inject.Singleton;
import me.school.bank.account.BaseBankAccount;
import me.school.bank.account.SaveBankAccount;
import me.school.bank.account.StudentBankAccount;
import me.school.bank.moneyTransfer.fee.FeeConfigurationLoader;
import me.school.bank.moneyTransfer.fee.FeeConfigurator;

@Singleton
public class MoneyTransferFeeCalculator {
    private final FeeConfigurationLoader feeConfigurationLoader;

    public MoneyTransferFeeCalculator() {
        this.feeConfigurationLoader = new FeeConfigurationLoader();
    }

    public double calculateTransferFee(BaseBankAccount account, double transferAmount) {
        FeeConfigurator feeConfigurator = this.feeConfigurationLoader.loadFeeConfig(account);

        return calculateFee(feeConfigurator, transferAmount);
    }

    private double calculateFee(FeeConfigurator feeConfigurator, double transferAmount) {
        if (feeConfigurator.isFreeFee()) {
            return 0;
        }

        double fee = feeConfigurator.getBaseFee();

        if (transferAmount >= feeConfigurator.getPercentLimit()) {
            fee += (transferAmount / 100 * feeConfigurator.getBasePercent());
        }

        return fee;
    }
}