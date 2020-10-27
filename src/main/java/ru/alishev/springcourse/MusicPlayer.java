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

    private final List<Music> musicList;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private Integer volume;

    @Autowired
    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
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
        int listSize = musicList.size();
        int i1 = random.nextInt(listSize);
        List<String> songs = musicList.get(i1).getSongs();
        int i2 = random.nextInt(songs.size());
        return "Playing: " + songs.get(i2);
    }
}
