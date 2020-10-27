package ru.alishev.springcourse;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RapMusic implements Music {

    private final List<String> songs;

    {
        songs = Arrays.asList("Lose Yourself", "It Was A Good Day", "In Da Club");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
