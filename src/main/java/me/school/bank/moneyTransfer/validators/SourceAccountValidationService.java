package me.school.bank.moneyTransfer.validators;

import com.google.inject.Singleton;
import me.school.bank.account.BaseBankAccount;

@Singleton
final public class SourceAccountValidationService {
    public void validateSourceAccountForTransfer(BaseBankAccount sourceAccount, double transferAmount) throws Exception {
        if (sourceAccount.getCurrentBalance() < transferAmount) {
            throw new Exception();
        }
    }
}
