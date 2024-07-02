package ru.kshnyakin.kg.education.google.guice.tipe3;

import com.google.inject.AbstractModule;

public class CalculatorModule extends AbstractModule {

    @Override
    protected void configure() {
        requestStaticInjection();
        bind(Calculator.class).to(CalculatorImpl.class);
//        bind(Calculator.class).to(CalculatorImpl.class).in(Singleton.class);
//        bind(Calculator.class).to(CalculatorImpl.class).in(Scopes.SINGLETON);
//        bind(Calculator.class).toInstance(new CalculatorImpl());
    }
}
