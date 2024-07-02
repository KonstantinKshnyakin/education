package ru.kshnyakin.kg.education.google.guice.tipe4;

import com.google.inject.ImplementedBy;

@ImplementedBy(CalculatorServiceImpl.class)
public interface CalculatorService {

    public int calculate(int a, int b, String oper);

}
