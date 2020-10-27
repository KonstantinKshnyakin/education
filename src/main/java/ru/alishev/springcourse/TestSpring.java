package ru.alishev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Music musicBean1 = context.getBean("rockMusic", Music.class);
        Music musicBean2 = context.getBean("classicMusic", Music.class);
        Music musicBean3 = context.getBean("rapMusic", Music.class);

        MusicPlayer musicPlayer = new MusicPlayer(Arrays.asList(musicBean1, musicBean2, musicBean3));
        musicPlayer.playMusic();

        context.close();
    }
}
