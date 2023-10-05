package me.school.moneytransfer;

import me.school.account.BaseBankAccount;

public class SourceValidationService {
    public void validateSourceAccountForMoneyTransfer(BaseBankAccount sourceAccount, double value) throws Exception {
        if (sourceAccount.getBlanace() < value) {
            throw new Exception("");
        }
    }
}
