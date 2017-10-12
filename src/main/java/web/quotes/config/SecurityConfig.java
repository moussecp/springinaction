package web.quotes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import web.quotes.data.user.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // hardcoded values
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER").and()
//                .withUser("admin").password("password").roles("USER", "ADMIN");

        // values coming from User repository
        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> configurer = auth.inMemoryAuthentication().passwordEncoder(new StandardPasswordEncoder());
        userRepository.findAll().forEach(user -> configurer.withUser(user.getUsername()).password(user.getPassword()).roles("USER"));

        // values coming from a jdbc data source
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select username, password, true " +
//                                "from User where username=?")
//                .authoritiesByUsernameQuery(
//                        "select username, 'ROLE_USER' from User where username=?")
//                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));

        // values coming from LDAP
//        auth
//                .ldapAuthentication()
//                .userSearchBase("ou=people")
//                .userSearchFilter("(uid={0})")
//                .groupSearchBase("ou=groups")
//                .groupSearchFilter("member={0}")
//                .contextSource()
//                .url("ldap://habuma.com:389/dc=habuma,dc=com");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
            .and().httpBasic()
            .and().authorizeRequests()
                .anyRequest().authenticated()
//            .and().requiresChannel()
//                .antMatchers("/login").requiresInsecure()
//                .anyRequest().requiresSecure() //requires https
            .and().rememberMe()
                .tokenValiditySeconds(5*60)
                .key("someKey")
            .and().logout()
                .logoutSuccessUrl("/login")
        ;
    }
}