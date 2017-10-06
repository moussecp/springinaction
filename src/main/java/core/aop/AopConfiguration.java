package core.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AopConfiguration {

    @Bean
    public Performance theatre() {
        return new Theatre();
    }

    @Bean
    public Performance cinema() {
        return new Cinema();
    }

    @Bean
    public Encoreable encoreable() {
        return new DefaultEncoreable();
    }

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }
}
