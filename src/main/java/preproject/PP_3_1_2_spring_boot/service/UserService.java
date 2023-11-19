package preproject.PP_3_1_2_spring_boot.service;

import org.springframework.stereotype.Service;
import preproject.PP_3_1_2_spring_boot.models.User;

import java.util.List;


@Service
public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void removeUser(long id);

    void updateUser(User user);
}
