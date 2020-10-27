package ru.alishev.springcourse;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ClassicMusic implements Music {

    private final List<String> songs;

    {
        songs = Arrays.asList("Hungarian Rhapsody", "The Four Seasons", "Boléro");
    }

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
    public List<String> getSongs() {
        return songs;
    }
}
