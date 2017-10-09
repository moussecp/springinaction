package web.quotes.data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryDummyImpl implements UserRepository {

    private static List<User> users = new ArrayList<>();

    @Override
    public User find(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public User find(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public boolean exists(String username) {
        return find(username) != null;
    }

    @Override
    public User save(User user) {
        User foundUser = find(user.getUsername());
        if (foundUser != null) {
            return foundUser;
        } else {
            users.add(user);
            return user;
        }
    }

    @Override
    public boolean delete(Long id) {
        User user = find(id);
        if (user != null) {
            return users.remove(user);
        } else {
            return false;
        }
    }
}
