package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDAOService {
    private int count;
    private List<User> user;
    {
        user = new ArrayList<>();
        user.add(new User(++count, "Ivan", "Ivanow", "ivanoff@mai.ru"));
        user.add(new User(++count, "Gleb", "Chernyakovskiy", "hlebbass@gmail.com"));
        user.add(new User(++count, "Roma", "Michurin", "mich88@yandex.ru"));
        user.add(new User(++count, "Mark", "Panteleyev", "markMujhik@rambler.ru"));
    }
    public List<User> index(){
        return user;
    }
    public User read(int id){
        return user.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
    public void save (User newUser) {
        newUser.setId(++count);
        user.add(newUser);
    }

    public void update(int id, User updateUser) {
        User changeUser = read(id);
        changeUser.setName(updateUser.getName());
    }

    public void delete(int id) {
        user.removeIf(p -> p.getId() == id);
    }
}