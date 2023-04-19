package web.dao;
import web.models.User;
import java.util.List;

public interface UserDao {
    List<User> showAllUsers();
    User show(int id);
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);

}
