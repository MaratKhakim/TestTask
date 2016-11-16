package com.springapp.mvc.controller;

import com.springapp.mvc.model.User;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user")
    public String setupForm(Map<String, Object> map){
        User user = new User();
        map.put("user", user);
        map.put("listUsers", userService.listUsers());

        return "user";
    }

    @RequestMapping(value = "user.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute User user, BindingResult result, @RequestParam String action, Map<String, Object> map){
        User userResult = new User();
        switch (action.toLowerCase()){
            case "add":
                userService.addUser(user);
                userResult = user;
                break;
            case "edit":
                userService.editUser(user);
                userResult = user;
                break;
            case "delete":
                userService.deleteUser(user.getId());
                userResult = user;
                break;
            case "search":
                User searchedUser = userService.getUserById(user.getId());
                userResult = searchedUser!=null ? searchedUser : new User();
                break;
        }
        map.put("user", userResult);
        map.put("listUsers", userService.listUsers());
        return "user";
    }
}
