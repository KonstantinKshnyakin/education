package ru.alishev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {

    private RockMusic rockMusic;
    private ClassicMusic classicMusic;
    private RapMusic rapMusic;
    private String name;
    private Integer volume;

    @Autowired
    public MusicPlayer(RockMusic rockMusic, ClassicMusic classicMusic, RapMusic rapMusic) {
        this.rockMusic = rockMusic;
        this.classicMusic = classicMusic;
        this.rapMusic = rapMusic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String playMusic() {
        return "Playing: " + classicMusic.getSong();
    }
}
