package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> showAllUsers();
    User getUserById(long id);
    void save(User user);
    void update(long id, User updatedUser);
    void delete(long id);
}
