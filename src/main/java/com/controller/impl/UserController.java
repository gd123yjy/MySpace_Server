package com.controller.impl;

import com.bean.Article;
import com.bean.Paragraphs;
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


    @Override
    public void createUser(String username, String password, String email) {

    }

    @Override
    public void updateSelf(int userid, String username, String password, String email, String note) {

    }

    @Override
    public User findUser(int userid) {
        return null;
    }

    @Override
    public void deleteUser(int userid) {

    }

    @Override
    public void savePersonalNote(int userid, String note) {

    }

    @Override
    public String findPersonalNote(int userid) {
        return null;
    }

    @Override
    public void createPersonalParagraph(int userid, int chapter_id, int paragraph_sequence) {

    }

    @Override
    public Paragraphs findPersonalParagraph(int userid) {
        return null;
    }

    @Override
    public void updatePersonalParagraph(int paragraphid, String content) {

    }

    @Override
    public void deletePersonalParagraph(int paragraphid) {

    }

    @Override
    public void chageUserPrivilege(int userid, boolean[] privilege) {

    }
}
