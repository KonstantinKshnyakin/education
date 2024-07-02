package ru.kshnyakin.kg.education.google.guice.tipe4;

import com.google.inject.ImplementedBy;

@ImplementedBy(CalculatorImpl.class)
public interface Calculator {

    int addition(int a, int b);

    int substraction(int a, int b);

    int multiply(int a, int b);

    int division(int a, int b);

}
