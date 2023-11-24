package preproject.PP_3_1_2_spring_boot.dao;

import org.springframework.stereotype.Repository;
import preproject.PP_3_1_2_spring_boot.model.User;

import java.util.List;


@Repository
public interface UserDao {
    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(long id);

    void editUser(User user);

    User showUserById(long id);
}
