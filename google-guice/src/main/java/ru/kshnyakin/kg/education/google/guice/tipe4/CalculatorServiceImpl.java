package ru.kshnyakin.kg.education.google.guice.tipe4;

import com.google.inject.Singleton;
import jakarta.inject.Inject;

@Singleton
public class CalculatorServiceImpl implements CalculatorService {

    @Inject
    private Calculator calculator;

    public int calculate(int a, int b, String oper) {
        if ("add".equals(oper)) {
            return calculator.addition(a, b);
        } else if ("sub".equals(oper)) {
            return calculator.substraction(a, b);
        } else if ("div".equals(oper)) {
            return calculator.division(a, b);
        } else if ("mul".equals(oper)) {
            return calculator.multiply(a, b);
        }
        throw new IllegalArgumentException(oper);
    }

}
