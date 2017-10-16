package com.hermes.training.spring.quotes.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // Enable Spring MVC
@ComponentScan("com.hermes.training.spring.quotes.web") // Enable component-scanning
public class WebConfig extends WebMvcConfigurerAdapter {

    // handles views for Spring MVC. Configure a JSP view resolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    // handles resource bundles properties files
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/messages/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    // handles how client's locale is resolved
//    @Bean
//    public LocaleResolver localeResolver(){
//        CookieLocaleResolver resolver = new CookieLocaleResolver();
//        resolver.setDefaultLocale(new Locale("en"));
//        resolver.setCookieName("myLocaleCookie");
//        resolver.setCookieMaxAge(4800);
//        return resolver;
//    }

    // handles static content configuration. By calling enable() on the given DefaultServletHandlerConfigurer,
    // you’re asking DispatcherServlet to forward requests for static resources to the servlet container’s default
    // servlet and not to try to handle them itself.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}