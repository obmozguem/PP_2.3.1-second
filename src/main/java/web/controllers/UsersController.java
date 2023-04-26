package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")

public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "allUsers";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.save(user);
        return "redirect:/users";
    }

//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") long id) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") long id) {
//        if (bindingResult.hasErrors()) {
//            return "edit";
//        }
//        userService.update(id, user);
//        return "redirect:/users";
//    }
        @GetMapping("/edit")
    public String edit(@RequestParam(value = "id", required = false) Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }
    @PostMapping(value = "/edit")
    public String update(@ModelAttribute("user") /*@Valid*/ User user/*, BindingResult bindingResult*/) {
//        if (bindingResult.hasErrors()) {
//            return "edit";
//        }
        userService.update(user);
        return "redirect:/users";
    }

//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        userService.delete(id);
//        return "redirect:/users";
//    }
@PostMapping(value = "/delete")
public String deleteUser(@RequestParam(value = "id", required = false) Long id) {
    userService.delete(id);
    return "redirect:/users";
}
}
