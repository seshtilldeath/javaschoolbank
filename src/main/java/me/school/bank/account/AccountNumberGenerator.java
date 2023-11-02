package me.school.bank.account;

import com.google.inject.Singleton;
import java.util.concurrent.ThreadLocalRandom;

@Singleton
public class AccountNumberGenerator {
    public String generateUniqueNumber() {
        long randomNumber = ThreadLocalRandom.current().nextLong(1_000_000_000L, 10_000_000_000L);

        return Long.toString(randomNumber);
    }
}