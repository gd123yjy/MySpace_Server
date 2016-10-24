package com.controller.impl;

import com.bean.Article;
import com.bean.User;
import com.controller.IUserController;
import com.service.JournalService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by yjy on 16-10-23.
 */

@Controller()
@RequestMapping(value = "/v1/user/")
public class UserController implements IUserController {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }



}
