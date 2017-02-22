package com.epam.test.web_app.controllers;

import com.epam.test.dao.User;
import com.epam.test.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


/**
 * Users Controller.
 */
@Controller
public class UsersController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public String users(Model model) {
        LOGGER.debug(" /users page.");
        List usersList = userService.getAllUsers();
        model.addAttribute("usersList", usersList);
        return "users";
    }

    @GetMapping(value = "/user")
    public String hello(@RequestParam("id") Integer id,
                        Model model) {
        LOGGER.debug("/user({})",id);
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user";
    }
}