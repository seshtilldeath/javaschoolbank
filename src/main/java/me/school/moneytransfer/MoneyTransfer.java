package me.school.moneytransfer;

import me.school.account.BaseBankAccount;
import me.school.moneytransfer.Fee;

public class MoneyTransfer {
    private final SourceValidationService sourceValidationService;
    private final Fee feee;

    public MoneyTransfer() {
        this.sourceValidationService = new SourceValidationService();
        this.feee = new Fee();
    }

    public void transferMoney(BaseBankAccount sourceAccount, BaseBankAccount destinationAccount, double value) throws Exception {
        sourceValidationService.validateSourceAccountForMoneyTransfer(sourceAccount, value);

        sourceAccount.setBlanace(sourceAccount.getBlanace() - value);
        destinationAccount.setBlanace(destinationAccount.getBlanace() + value);
    }

    public void transferMoneyByATM(BaseBankAccount sourceAccount, double value) throws Exception {
        sourceValidationService.validateSourceAccountForMoneyTransfer(sourceAccount, value);

        sourceAccount.setBlanace(sourceAccount.getBlanace() - value);
    }
}
