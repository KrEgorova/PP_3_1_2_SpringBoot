package preproject.PP_3_1_2_spring_boot.dao;

import org.springframework.stereotype.Repository;
import preproject.PP_3_1_2_spring_boot.models.User;

import java.util.List;


@Repository
public interface UserDao {
    List<User> getAllUsers();

    void saveUser(User user);

    void removeUser(long id);

    void updateUser(User user);
}
