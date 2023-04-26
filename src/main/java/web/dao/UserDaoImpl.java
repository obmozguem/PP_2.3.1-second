package web.dao;


import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> showAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

//    @Override
//    public void update(long id, User updatedUser) {
//        User userToBeUpdated = getUserById(id);
//
//        userToBeUpdated.setFirstName(updatedUser.getFirstName());
//        userToBeUpdated.setLastName(updatedUser.getLastName());
//        userToBeUpdated.setUsername(updatedUser.getUsername());
//        userToBeUpdated.setAge(updatedUser.getAge());
//        userToBeUpdated.setEmail(updatedUser.getEmail());
//        userToBeUpdated.setPassword(updatedUser.getPassword());
//        entityManager.merge(userToBeUpdated);
//    }


    @Override
    public void update(User user) {
        if (getUserById(user.getId()) != null) {
            entityManager.merge(user);
        }
    }

    @Override
    public void delete(Long id) {
        if (getUserById(id) != null) {
            entityManager.remove(getUserById(id));
        }
    }
}
