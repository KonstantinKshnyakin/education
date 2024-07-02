package ru.kshnyakin.kg.education.google.guice.tipe4;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class CalculatorClient {

    @Inject
    private static CalculatorService calculatorService;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
//        CalculatorService calculatorService = injector.getInstance(CalculatorService.class);
        System.out.println(calculatorService);
        System.out.println("addition: " + calculatorService.calculate(5, 2, "add"));
        System.out.println("division: " + calculatorService.calculate(5, 2, "div"));
        System.out.println("multiply: " + calculatorService.calculate(5, 2, "mul"));
        System.out.println("substraction: " + calculatorService.calculate(5, 2, "sub"));
        CalculatorService calculatorService2 = injector.getInstance(CalculatorService.class);
        System.out.println(calculatorService2);
    }

}
