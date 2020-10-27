package ru.alishev.springcourse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "ru.alishev.springcourse")
@PropertySource(value = "classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public List<Music> getMusicList() {
        return Arrays.asList(new ClassicMusic(), new RapMusic(), new RockMusic());
    }
}
