package web.quotes.config;

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
@ComponentScan("web.quotes.web") // Enable component-scanning
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

//
//    // handles the contentNegotiation for http requests
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.defaultContentType(MediaType.APPLICATION_XML);
////        configurer.defaultContentType(MediaType.APPLICATION_JSON);
////        configurer.defaultContentType(MediaType.TEXT_HTML);
//    }
//
//    // the ContentNegotiatingViewResolver now takes on the behavior defined in the ContentNegotiationManager
//    @Bean
//    public ViewResolver cnViewResolver(ContentNegotiationManager contentNegotiationManager) {
//        ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
//        contentNegotiatingViewResolver.setContentNegotiationManager(contentNegotiationManager);
//        return contentNegotiatingViewResolver;
//    }
//
//    // Look up views as beans
//    @Bean
//    public ViewResolver beanNameViewResolver() {
//        return new BeanNameViewResolver();
//    }
//
//    // "quotes" JSON/XML view
//    @Bean
//    public View quotes() {
//        return new MappingJackson2XmlView();
////        return new MappingJackson2JsonView();
//    }
}