package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDAO;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserDAO userDAO;
    @Autowired
    public UserController (UserDAO userDAO){
        this.userDAO = userDAO;
    }
    @GetMapping()
    public String index(Model model){
        //get all peoples from DAO & setting and we will pass on the display and presentation
        model.addAttribute("users", userDAO.index());
        return "user/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        //Получим одного человека по ИД из ДАО и передадим на отображение в представление
        model.addAttribute("user", userDAO.show(id));
        return "user/show";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "user/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userDAO.save(user);
        return "redirect:/users";       //Переход на страницу списка
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userDAO.show(id));
        return "user/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDAO.update(id, user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userDAO.delete(id);
        return "redirect:/users";
    }
}
