package web.mvc.hibernate.service;

import web.mvc.hibernate.model.User;

import java.util.List;


public interface UserService {



    List<User> getAllUsers();

    User getUserById(int id);

    void saveUser(User user);

    User updateUser(int id, String newName, String newLastName);

    void deleteUser(int id);

}
