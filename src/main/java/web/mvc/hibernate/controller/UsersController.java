package web.mvc.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.mvc.hibernate.model.User;
import web.mvc.hibernate.service.UserService;

import java.util.List;

@Controller
public class UsersController {

     private UserService userService;

     @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public String getAllUsers (Model model) {
        model.addAttribute("allUsers",userService.getAllUsers());
        return "all-users";
    }
    @GetMapping(path = "/{id}user")
    public String getUserById (@PathVariable("id") int id, Model model ){
        model.addAttribute("user", userService.getUserById(id));
        return "idUser";
    }
    @PostMapping("/new")
    public String saveUser (@PathVariable("id")int id, @ModelAttribute ("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
    @PostMapping("/update")
    public String updateUser (@PathVariable("id")int id, @ModelAttribute("user") User user) {
        userService.updateUser(id,user.getName(),user.getLastname());
        return "upUser";
    }
    @DeleteMapping("{id}/delete")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }


}
