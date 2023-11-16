package me.school.bank;

import com.google.inject.Guice;
import com.google.inject.Injector;
import me.school.bank.notification.NotificationCustomerEvent;
import me.school.bank.notification.NotifyCustomerEventListener;

public class Main {
    public static void main(String args[]) throws Exception {
        try {
            Injector injector = Guice.createInjector(new BankInjector());
            Bank bank = injector.getInstance(Bank.class);

            injector.getInstance(NotifyCustomerEventListener.class);

            bank.run();
        } catch (Exception e) {
            System.out.println("ERROR IN BANK EXAMPLE");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}