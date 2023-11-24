package preproject.PP_3_1_2_spring_boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import preproject.PP_3_1_2_spring_boot.model.User;

import java.util.Comparator;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        users.sort(Comparator.comparingLong(User::getId));
        return users;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(long id) {
        User user = showUserById(id);
        entityManager.remove(user);
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User showUserById(long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            return user;
        } else {
            throw new NullPointerException("Пользователя с таким ID не существует!!!!!");
        }
    }
}
