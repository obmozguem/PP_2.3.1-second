package web.dao;


import org.springframework.stereotype.Repository;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
//    private static long USERS_COUNT;
    private List<User> users;

//    {
//        users = new ArrayList<>();
//        users.add(new User(++USERS_COUNT,"Olga", "Askerova", "Бульбуль", (byte) 36, "ole4kaask@mail.ru", "12345345"));
//        users.add(new User(++USERS_COUNT,"Petr", "Ivanov", "Petruxa", (byte) 25, "petruxaJiEst@yandex.ru", "124578"));
//        users.add(new User(++USERS_COUNT,"Irina", "Semenova", "IriwkaMartiwka", (byte) 21, "irina_kartina.ru", "0982"));
//        users.add(new User(++USERS_COUNT,"Svetlana", "Ponomareva", "SvetkaPipetlka", (byte) 45, "zvezdaBaleta@yandex.ru", "3740"));
//        users.add(new User(++USERS_COUNT,"Evgeniy", "Dyatlov", "Maestro", (byte) 35, "master_evg@gmail.com", "2394"));
//    }

    @Override
    public List<User> showAllUsers() {
        return users;
    }

    @Override
    public User show(long id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
//        user.setId(++USERS_COUNT);
        users.add(user);
    }

    @Override
    public void update(long id, User updatedUser) {
        User userToBeUpdated = show(id);

        userToBeUpdated.setFirstName(updatedUser.getFirstName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setUsername(updatedUser.getUsername());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
        userToBeUpdated.setPassword(updatedUser.getPassword());

    }

    @Override
    public void delete(long id) {
        users.removeIf(user -> user.getId() == id);
    }
}
