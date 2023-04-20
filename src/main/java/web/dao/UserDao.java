package web.dao;
import web.models.User;
import java.util.List;

public interface UserDao {
    List<User> showAllUsers();
    User show(long id);
    void save(User user);
    void update(long id, User updatedUser);
    void delete(long id);

}
