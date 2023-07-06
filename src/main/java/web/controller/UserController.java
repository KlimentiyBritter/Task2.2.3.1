package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserDAOService;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserDAOService userDAOService;
    @Autowired
    public UserController (UserDAOService userDAO){
        this.userDAOService = userDAO;
    }
    @GetMapping()
    public String index(Model model){
        //get all peoples from DAO & setting and we will pass on the display and presentation
        model.addAttribute("users", userDAOService.index());
        return "user/index";
    }
//    @GetMapping("/{id}")
//    public String read(@PathVariable("id") int id, Model model){
//        //Получим одного человека по ИД из ДАО и передадим на отображение в представление
//        model.addAttribute("user", userDAOService.read(id));
//        return "user/show";
//    }
    @RequestMapping("/?id=")
    public String read(@RequestParam(value = "id", required = false) Integer id, Model model) {
        //Получим одного человека по ИД из ДАО и передадим на отображение в представление
        User user = userDAOService.read(id);
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        return "user/show";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "user/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userDAOService.save(user);
        return "redirect:/users";       //Переход на страницу списка
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userDAOService.read(id));
        return "user/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDAOService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userDAOService.delete(id);
        return "redirect:/users";
    }
}