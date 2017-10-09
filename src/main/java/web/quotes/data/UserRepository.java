package web.quotes.data;

import java.util.List;

public interface UserRepository {
    User find(Long id);

    User find(String username);

    List<User> findAll();

    boolean exists(String username);

    User save(User user);

    boolean delete(Long id);
}
