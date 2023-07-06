package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getListOfUsers();
    void create(User user);
    User readUserById(int id);
    void update(User user);
    void delete(int id);
}
