package preproject.PP_3_1_2_spring_boot.service;

import org.springframework.stereotype.Service;
import preproject.PP_3_1_2_spring_boot.model.User;

import java.util.List;


@Service
public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(long id);

    void editUser(User user);

    User showUserById(long id);
}
