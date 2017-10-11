package web.quotes.data.user;

import java.util.List;

public interface UserRepository {
    User find(Long id);

    User find(String username);

    List<User> findAll();

    List<User> findAllLike(String username);

    boolean exists(String username);

    User save(User user);

    boolean delete(Long id);
}
