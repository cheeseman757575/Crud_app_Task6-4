package web.mvc.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.mvc.hibernate.dao.UserDao;
import web.mvc.hibernate.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User updateUser(int id, String newName, String newLastName) {
        userDao.updateUser(id, newName, newLastName);
        User user = userDao.getUserById(id);

        return user;
    }

    @Override
    public void deleteUser(int id) {

    }
}
