package web.quotes.data;

import com.google.common.base.Preconditions;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class User {
    private static Long idSequence = 0L;

    private final Long id;
    @NotNull
    @Size(min = 5, max = 16, message = "{username.size}")
    private String username;
    @NotNull
    @Size(min = 5, max = 25, message = "{password.size}")
    private String password;
    @NotNull
    @Size(min = 2, max = 30, message = "{firstName.size}")
    private String firstName;
    @NotNull
    @Size(min = 2, max = 30, message = "{lastName.size}")
    private String lastName;
    @NotNull
    @Email(message = "{email.valid}")
    private String email;

    //used for form only
    public User() {
        this.id = ++idSequence;
    }

    public User(String email, String username, String password) {
        this("", "", email, username, password);
    }

    public User(String firstName, String lastName, String email, String username, String password) {
        Preconditions.checkNotNull(username, "username cannot be null");
        Preconditions.checkNotNull(password, "password cannot be null");
        this.id = ++idSequence;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
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
        this.password = password;
    }
}
