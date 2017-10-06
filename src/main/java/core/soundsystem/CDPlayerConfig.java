package core.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//@ComponentScan
@PropertySource("classpath:resources.properties")
public class CDPlayerConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "beatlesPlayer")
    public MediaPlayer mediaPlayer()  {
        return new CDPlayer(sgtPepper());
    }

    @Bean(name = "metallicaPlayer")
    public MediaPlayer metallicaMediaPlayer()  {
        return new CDPlayer(saintAnger());
    }

    @Bean
    public CompactDisc sgtPepper() {
        return new SgtPeppers();
    }

    @Bean
    public CompactDisc saintAnger() {
        return new SaintAnger();
    }
}
