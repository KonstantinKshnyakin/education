package ru.alishev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class Computer {

    private int id;
    private MusicPlayer musicPlayer;

    @Autowired
    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        Random random = new Random();
        int length = MusicGenre.values().length;
        int i = random.nextInt(length);
        return "Computer "
                + "id=" + id
                + ", musicPlayer=" + musicPlayer.playMusic(MusicGenre.values()[i]);
    }
}
