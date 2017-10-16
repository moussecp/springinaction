package com.hermes.training.spring.quotes.data.user;

import com.hermes.training.spring.quotes.data.DummyData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryDummyImpl implements UserRepository {

    private static List<User> users = new ArrayList<>();

    static {
        users = DummyData.getBootstrapUsers();
    }

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
    public List<User> findAllLike(String username) {
        return users.stream()
                .filter(user -> user
                        .getUsername().toUpperCase()
                        .contains(username.toUpperCase()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean exists(String username) {
        return find(username) != null;
    }

    @Override
    public User save(User user) {
        User foundUser = find(user.getUsername());
        if (foundUser != null) {
            throw new UserAlreadyExistsException(foundUser.getUsername());
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
