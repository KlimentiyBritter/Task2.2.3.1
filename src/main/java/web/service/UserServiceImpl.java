package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Transactional
    @Override
    public List<User> getListOfUsers() {
        return userDao.getListOfUsers();
    }

    @Transactional
    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Transactional
    @Override
    public User readUserById(int id) {
        return userDao.readUserById(id);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
