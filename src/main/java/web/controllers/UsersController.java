package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.models.User;

@Controller
@RequestMapping("/users")

public class UsersController {
    private final UserDaoImpl userDao;

    @Autowired
    public UsersController(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userDao.showAllUsers());
        return "allUsers";
    }
    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDao.show(id));
        return "show";
    }
    @GetMapping("/new")
    public String newUser (@ModelAttribute("user") User user) {
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userDao.save(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String edit (Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDao.show(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update (@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDao.update(id, user);
        return "redirect:/users";
    }



}
