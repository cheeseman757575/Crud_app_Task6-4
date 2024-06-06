package web.mvc.hibernate.dao;

import web.mvc.hibernate.model.User;

import java.util.List;

public interface UserDao {


    List<User> getAllUsers();

    User getUserById(int id);

    void saveUser(User user);

    void updateUser(int id, String newName, String newLastName);

    void deleteUser(int id);


}
