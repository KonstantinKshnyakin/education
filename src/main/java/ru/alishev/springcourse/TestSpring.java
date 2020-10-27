package ru.alishev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ClassicMusic classicMusic1 = context.getBean("classicMusic", ClassicMusic.class);
        ClassicMusic classicMusic2 = context.getBean("classicMusic", ClassicMusic.class);
        ClassicMusic classicMusic3 = context.getBean("classicMusic", ClassicMusic.class);
        System.out.println(classicMusic1.getSong());
        System.out.println(classicMusic2.getSong());
        System.out.println(classicMusic3.getSong());

//        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//        System.out.println(firstMusicPlayer == secondMusicPlayer);
//        System.out.println(firstMusicPlayer);
//        System.out.println(secondMusicPlayer);
//
//        secondMusicPlayer.setName("secondMusicPlayer");
//        secondMusicPlayer.setVolume(88);
//        firstMusicPlayer.playMusic();
//        System.out.println(firstMusicPlayer.getName());
//        System.out.println(firstMusicPlayer.getVolume());
//        System.out.println(secondMusicPlayer.getName());
//        System.out.println(secondMusicPlayer.getVolume());

        context.close();
    }
}
