package application;

import domain.model.user.User;
import domain.model.user.UserName;
import domain.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(String argUserName) {
        UserName userName = new UserName(argUserName);
        User user = new User(userName);
        if (this.userRepository.ofName(userName) != null) {
            return;
        }
        this.userRepository.save(user);
    }

    public User ofName(String argUserName) {
        UserName userName = new UserName(argUserName);
        return this.userRepository.ofName(userName);
    }

    public List<User> getAll() {
        return this.userRepository.getAll();
    }
}
