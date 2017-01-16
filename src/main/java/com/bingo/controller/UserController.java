package com.bingo.controller;

import com.bingo.dao.UserDao;
import com.bingo.entity.User;
import com.bingo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Writer;

/**
 * Created by Administrator on 2016/12/13 0013.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String user(@PathVariable int id) {
        User user = userService.selectUser(id);
        return String.format("username: %s, password: %s", user.getName(), user.getPassword());
    }
}
