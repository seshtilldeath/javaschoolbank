package me.school.moneytransfer;

import me.school.account.BaseBankAccount;
import me.school.account.StundentBankAccount;
import me.school.moneytransfer.Fee;

public class MoneyTransfer {
    private final SourceValidationService sourceValidationService;
    private final Fee fee;

    public MoneyTransfer() {
        this.sourceValidationService = new SourceValidationService();
        this.fee = new Fee();
        fee.map.put(BaseBankAccount.class, 5);
        fee.map.put(StundentBankAccount.class, 2);
    }

    public void transferMoney(BaseBankAccount sourceAccount, BaseBankAccount destinationAccount, double value) throws Exception {
        sourceValidationService.validateSourceAccountForMoneyTransfer(sourceAccount, value);

        sourceAccount.setBlanace(sourceAccount.getBlanace() - fee.addFee(value, sourceAccount));
        destinationAccount.setBlanace(destinationAccount.getBlanace() + fee.addFee(value, sourceAccount));
    }

    public void transferMoneyByATM(BaseBankAccount sourceAccount, double value) throws Exception {
        sourceValidationService.validateSourceAccountForMoneyTransfer(sourceAccount, value);

        sourceAccount.setBlanace(sourceAccount.getBlanace() - fee.addFee(value, sourceAccount));
    }
}
