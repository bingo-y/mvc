package com.bingo.controller;

import com.bingo.controller.support.handler.Token;
import com.bingo.controller.support.msg.Message;
import com.bingo.entity.User;
import com.bingo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/12/13 0013.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object user(@PathVariable int id) {
        User user = userService.selectUser(id);
        LOG.info("get user");
        return Message.okMessage(String.format("username: %s, password: %s", user.getName(), user.getPassword()));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object list(@Token String token) {
        LOG.info("get user list");
        return Message.okMessage(token);
    }
}
