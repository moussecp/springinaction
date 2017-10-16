package com.hermes.training.spring.quotes.data.user;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;


public class User {
    private static Long idSequence = 0L;

    private final Long id = ++idSequence;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    //used for form only
    public User() {
    }

    public User(String email, String username, String password) {
        this("", "", email, username, password);
    }

    public User(String firstName, String lastName, String email, String username, String password) {
        checkArgument(!isNullOrEmpty(username), "username cannot be null");
        checkArgument(!isNullOrEmpty(password), "password cannot be null");
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = getEncodedPassword(password);
    }

    private String getEncodedPassword(String password) {
        return new StandardPasswordEncoder().encode(password);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = getEncodedPassword(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
