package preproject.PP_3_1_2_spring_boot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import preproject.PP_3_1_2_spring_boot.model.User;
import preproject.PP_3_1_2_spring_boot.service.UserService;


@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String printAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", userService.getAllUsers());
            return "users";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/page-delete")
    public String pageForDelete(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.showUserById(id));
        return "delete";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/users/page-edit")
    public String pageForEdit(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.showUserById(id));
        return "edit";
    }

    @PostMapping("/users/edit")
    public String editUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.editUser(user);
        return "redirect:/users";
    }
}
