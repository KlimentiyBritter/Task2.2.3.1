package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<User> getListOfUsers() {
        return manager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void create(User user) {
        manager.persist(user);
    }

    @Override
    public User readUserById(int id) {
        return manager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        manager.merge(user);
    }
    @Override
    public void delete(int id) {
        User user = manager.find(User.class, id);
        manager.remove(user);
    }
}
