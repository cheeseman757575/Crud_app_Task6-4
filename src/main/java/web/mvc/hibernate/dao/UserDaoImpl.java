package web.mvc.hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import web.mvc.hibernate.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers()
    {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
    @Transactional(readOnly = true)  //для работы с хибером создаем Transactional
    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
            entityManager.persist(user);
        }
    @Transactional
    @Override
    public void updateUser(int id, String newName, String newLastName) {
        User user = entityManager.find(User.class, id);
        if (user != null){
            user.setName(newName);
            user.setLastname(newLastName);
        }
    }
    @Transactional
    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);


    }
}
