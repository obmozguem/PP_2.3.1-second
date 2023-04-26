package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> showAllUsers();

    User getUserById(Long id);

    void save(User user);

    //    void update(long id, User updatedUser);
    void update(User user);

    void delete(Long id);

}
