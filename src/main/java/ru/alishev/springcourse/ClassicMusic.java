package ru.alishev.springcourse;

import org.springframework.stereotype.Component;

@Component
public class ClassicMusic implements Music {

    private ClassicMusic() {
        System.out.println("ClassicMusic initialize in constructor");
    }

    public static ClassicMusic getClassicalMusic() {
        System.out.println("ClassicMusic initialize in factory methode");
        return new ClassicMusic();
    }

    public void doMyInit() {
        System.out.println("ClassicMusic-bean: doing my initialization");
    }

    public void doMyDestroy() {
        System.out.println("ClassicMusic-bean: doing my destroy");
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
