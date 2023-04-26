package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> showAllUsers();

    User getUserById(Long id);

    void save(User user);

    void update(User user);

    void delete(Long id);
}
