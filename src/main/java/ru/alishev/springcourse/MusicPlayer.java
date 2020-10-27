package ru.alishev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
@Scope("prototype")
public class MusicPlayer {

    private final HashMap<MusicGenre, Music> musicMap;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private Integer volume;

    @Autowired
    public MusicPlayer(@Qualifier("classicMusic") Music classicMusic,
                       @Qualifier("rockMusic") Music rockMusic,
                       @Qualifier("rapMusic") Music rapMusic) {
        this.musicMap = new HashMap<>(
                Map.of(
                        MusicGenre.CLASSIC, classicMusic,
                        MusicGenre.ROCK, rockMusic,
                        MusicGenre.RAP, rapMusic)
        );
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

    public String playMusic(MusicGenre musicGenre) {
        Random random = new Random();
        List<String> songs = musicMap.get(musicGenre).getSongs();
        int i = random.nextInt(songs.size());
        return "Playing: " + songs.get(i);
    }
}
