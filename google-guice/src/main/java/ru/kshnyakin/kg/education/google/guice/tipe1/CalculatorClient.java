package ru.kshnyakin.kg.education.google.guice.tipe1;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CalculatorClient {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new CalculatorModule());
        Calculator instance = injector.getInstance(Calculator.class);
        System.out.println("addition: " + instance.addition(5, 2));
        System.out.println("division: " + instance.division(5, 2));
        System.out.println("multiply: " + instance.multiply(5, 2));
        System.out.println("substraction: " + instance.substraction(5, 2));

    }

}
