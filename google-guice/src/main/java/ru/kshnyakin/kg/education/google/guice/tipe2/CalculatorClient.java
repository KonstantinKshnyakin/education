package ru.kshnyakin.kg.education.google.guice.tipe2;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CalculatorClient {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new CalculatorModule());
        Calculator calculator = injector.getInstance(Calculator.class);
        System.out.println(calculator);
        System.out.println("addition: " + calculator.addition(5, 2));
        System.out.println("division: " + calculator.division(5, 2));
        System.out.println("multiply: " + calculator.multiply(5, 2));
        System.out.println("substraction: " + calculator.substraction(5, 2));
        Calculator calculator2 = injector.getInstance(Calculator.class);
        System.out.println(calculator2);
    }

}
