package web.dao;


import org.springframework.stereotype.Repository;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private static int USERS_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User("Lada Priora", 2020, "silver metallic"));
        users.add(new User("Lada Vesta", 2019, "yellow"));
        users.add(new User("BMW X6", 2022, "black"));
        users.add(new User("Opel Astra", 2018, "grey"));
        users.add(new User("Toyota Camry", 2021, "white"));
    }

    @Override
    public List<User> showAllUsers() {
       return users;
    }

    @Override
    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        user.setId(++USERS_COUNT);
        users.add(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
        userToBeUpdated.setAge(updatedUser.getAge());
    }

    @Override
    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
