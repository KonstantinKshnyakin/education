package ru.alishev.springcourse;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RockMusic implements Music {

    private final List<String> songs;

    {
        songs = Arrays.asList("Wind cries Mary", "Led", "Speak to Me");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
