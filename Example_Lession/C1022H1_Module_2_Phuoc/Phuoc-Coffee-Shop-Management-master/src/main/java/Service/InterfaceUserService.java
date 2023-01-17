package Service;

import Model.User;

import java.util.List;

public interface InterfaceUserService {
    List<User> showUserView ();

    User userLogin(String username, String password);
    void add(User newUser);

    void update(User newUser);


    void removeUser(Long idUser, User user);

    boolean existById(Long id);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByUsername(String userName);

    public User findUserById(Long id);

    User adminLogin(String username, String password);
}
