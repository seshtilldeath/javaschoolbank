package me.school.bank;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import me.school.bank.print.ConsolePrintService;
import me.school.bank.print.PrintInterface;

public class BankInjector extends AbstractModule {
    private EventBus eventBus = new EventBus("Default EventBus");

    @Override protected void configure() {
        this.bind(PrintInterface.class).to(ConsolePrintService.class);
        this.bind(EventBus.class).toInstance(eventBus);

        bindListener(Matchers.any(), new TypeListener() {

            @Override
            public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
                encounter.register(new InjectionListener<I>() {
                    @Override
                    public void afterInjection(I injectee) {
                        eventBus.register(injectee);
                    }
                });
            }
        });
    }
}