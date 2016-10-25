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

    @RequestMapping(value = "",method = RequestMethod.POST)
    @Override
    public void createUser(@RequestParam String username,@RequestParam String password,@RequestParam(required = false) String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        userService.save(user);
    }

    @RequestMapping(value = "{userid}",method = RequestMethod.PUT)
    @Override
    public void updateSelf(@PathVariable int userid,@RequestParam(required = false) String username,@RequestParam(required = false) String password,@RequestParam(required = false) String email,@RequestParam(required = false) String note) {

    }

    @RequestMapping(value = "{userid}",method = RequestMethod.GET)
    @Override
    public User findUser(@PathVariable int userid) {
        return userService.find_user_by_userid(userid);
    }

    @RequestMapping(value = "{userid}",method = RequestMethod.DELETE)
    @Override
    public void deleteUser(@PathVariable int userid) {
        userService.update(null);
    }

    @RequestMapping(value = "{userid}/note",method = RequestMethod.POST)
    @Override
    public void savePersonalNote(@PathVariable int userid, String note) {
        userService.save_note_of_user(userid,note);
    }

    @RequestMapping(value = "{userid}/note",method = RequestMethod.GET)
    @Override
    public String findPersonalNote(@PathVariable int userid) {
        return userService.find_note_of_user(userid);
    }

    @RequestMapping(value = "{userid}/paragraph",method = RequestMethod.POST)
    @Override
    public void createPersonalParagraph(@PathVariable int userid,@RequestParam int chapter_id,@RequestParam int paragraph_sequence) {
//TODO
    }

    @RequestMapping(value = "{userid}/paragraph",method = RequestMethod.GET)
    @Override
    public Paragraphs findPersonalParagraph(int userid) {
        //TODO
        return null;
    }

    @RequestMapping(value = "{userid}/paragraph",method = RequestMethod.PUT)
    @Override
    public void updatePersonalParagraph(@RequestParam int paragraphid,@RequestParam String content) {
//TODO
    }

    @RequestMapping(value = "{userid}/paragraph",method = RequestMethod.DELETE)
    @Override
    public void deletePersonalParagraph(@RequestParam int paragraphid) {
//TODO
    }

    @RequestMapping(value = "{userid}/privilege",method = RequestMethod.PUT)
    @Override
    public void chageUserPrivilege(@PathVariable int userid,@RequestParam boolean[] privilege) {
//TODO
    }
}
