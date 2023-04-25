package web.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Consumer;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> showAllUsers() {
        Query query = entityManager.createQuery("SELECT e FROM User e");
        return query.getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
//        executeInsideTransaction(entityManager -> entityManager.persist(user));
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void update(long id, User updatedUser) {
        User userToBeUpdated = getUserById(id);

        userToBeUpdated.setFirstName(updatedUser.getFirstName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setUsername(updatedUser.getUsername());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
        userToBeUpdated.setPassword(updatedUser.getPassword());
        entityManager.merge(userToBeUpdated);
//        executeInsideTransaction(entityManager -> entityManager.merge(userToBeUpdated));
    }

    @Override
    @Transactional
    public void delete(long id) {
        entityManager.remove(getUserById(id));
//        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.find(User.class, id)));
    }
//    private void executeInsideTransaction(Consumer<EntityManager> action) {
//        EntityTransaction tx = entityManager.getTransaction();
//        try {
//            tx.begin();
//            action.accept(entityManager);
//            tx.commit();
//        }
//        catch (RuntimeException e) {
//            tx.rollback();
//            throw e;
//        }
//    }
}
