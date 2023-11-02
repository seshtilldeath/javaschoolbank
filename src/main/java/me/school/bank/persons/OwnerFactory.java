package me.school.bank.persons;

import com.google.inject.Inject;
import me.school.bank.print.PrintService;

import javax.inject.Singleton;

@Singleton
public class OwnerFactory {
    @Inject private PrintService printService;

    public Owner createOwner(String name, String lastName) {
        this.printService.debug("owner ...");

        return new Owner(name, lastName);
    }
}

