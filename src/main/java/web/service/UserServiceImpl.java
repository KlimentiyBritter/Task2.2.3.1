package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoHiber;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private UserDaoHiber userDaoHiber;
    @Autowired
    UserServiceImpl(UserDaoHiber userDaoHiber){
        this.userDaoHiber = userDaoHiber;
    }

    @Transactional
    @Override
    public List<User> getListOfUsers() {
        return userDaoHiber.getListOfUsers();
    }

    @Transactional
    @Override
    public void create(User user) {
        userDaoHiber.create(user);
    }

    @Transactional
    @Override
    public User readUserById(int id) {
        return userDaoHiber.readUserById(id);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDaoHiber.update(user);
    }
    @Transactional
    @Override
    public void delete(int id) {
        userDaoHiber.delete(id);
    }
}
