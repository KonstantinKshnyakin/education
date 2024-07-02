package ru.kshnyakin.kg.education.google.guice.tipe2;

public class CalculatorImpl implements Calculator {

    @Override
    public int addition(int a, int b) {
        return a + b;
    }

    @Override
    public int substraction(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int division(int a, int b) {
        return a / b;
    }

}
