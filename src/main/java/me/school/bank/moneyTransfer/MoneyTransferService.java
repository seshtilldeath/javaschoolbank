package me.school.bank.moneyTransfer;

import com.google.inject.Singleton;
import me.school.bank.account.BaseBankAccount;
import me.school.bank.moneyTransfer.validators.SourceAccountValidationService;

@Singleton
public class MoneyTransferService {
    private final SourceAccountValidationService sourceAccountValidationService;
    private final MoneyTransferFeeCalculator transferFeeCalculator;

    public MoneyTransferService() {
        this.sourceAccountValidationService = new SourceAccountValidationService();
        this.transferFeeCalculator = new MoneyTransferFeeCalculator();
    }

    public void transferMoney(BaseBankAccount sourceAccount, BaseBankAccount destinationAccount, double transferAmount) throws Exception {
        double transferFee = this.transferFeeCalculator.calculateTransferFee(sourceAccount, transferAmount);
        double totalAmountToTransfer = transferAmount + transferFee;

        this.sourceAccountValidationService.validateSourceAccountForTransfer(sourceAccount, totalAmountToTransfer);

        sourceAccount.substractFromBalance(totalAmountToTransfer);
        destinationAccount.addToBalance(transferAmount);
    }

    public void transferMoneyByATM(BaseBankAccount sourceAccount, double transferAmount) throws Exception {
        this.sourceAccountValidationService.validateSourceAccountForTransfer(sourceAccount, transferAmount);

        sourceAccount.substractFromBalance(transferAmount);
    }
}
