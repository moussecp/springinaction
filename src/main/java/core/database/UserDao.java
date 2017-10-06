package core.database;

import java.util.List;


public interface UserDao {

    User findByName(String name);

    List<User> findAll();

}