package spring_mvc_hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring_mvc_hibernate.model.User;
import spring_mvc_hibernate.service.UserService;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userServiceInterfaces) {
        this.userService = userServiceInterfaces;
    }

    @GetMapping("/users")
    public String getUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/users/delete")
    public String deleteUserById(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String newUserForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "newUserForm";
    }

    @GetMapping("/users/getUser")
    public String getUser(ModelMap modelMap, @RequestParam("id") long id) {
        modelMap.addAttribute(userService.getUserById(id));
        return "updateUserForm";
    }

    @PostMapping("users/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }
}
