package me.school.bank;

import com.google.inject.AbstractModule;
import me.school.bank.print.ConsolePrintService;
import me.school.bank.print.PrintInterface;

public class BankInjector extends AbstractModule {
    @Override protected void configure() {
        this.bind(PrintInterface.class).to(ConsolePrintService.class);
    }
}