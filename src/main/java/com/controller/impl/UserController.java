package com.controller.impl;

import com.bean.Article;
import com.bean.Paragraph;
import com.bean.Paragraphs;
import com.bean.User;
import com.controller.IUserController;
import com.service.JournalService;
import com.service.ParagraphService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yjy on 16-10-23.
 */

@RestController
@RequestMapping(value = "v1/user")
public class UserController implements IUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ParagraphService paragraphService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setParagraphService(ParagraphService paragraphService) {
        this.paragraphService = paragraphService;
    }

    @RequestMapping(value = {"","/"},method = RequestMethod.POST)
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
    public void updateSelf(@PathVariable Integer userid,@RequestParam(required = false) String username,@RequestParam(required = false) String password,@RequestParam(required = false) String email,@RequestParam(required = false) String note) {
        //TODO
        //不给参数的时候不应该用null覆盖原来的值
        User user = new User();
        user.setUserid(userid);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setNote(note);
        userService.update(user);
    }

    @RequestMapping(value = "{userid}",method = RequestMethod.GET,headers = {"accept=application/json"})
    @Override
    public User findUser(@PathVariable Integer userid) {
        // TODO: 16-11-20  
        //what if user==null,catch exception or use "if" statement?
        User user = userService.find_user_by_userid(userid);
        List<Paragraph> paragraphs = paragraphService.find_paragraphs_of_user(userid);
        user.setParagraphs(new HashSet<Paragraph>(paragraphs));
        return user;
    }

    @RequestMapping(value = "{userid}",method = RequestMethod.DELETE)
    @Override
    public void deleteUser(@PathVariable Integer userid) {
        userService.update(null);
    }

    @RequestMapping(value = "{userid}/note",method = RequestMethod.POST)
    @Override
    public void savePersonalNote(@PathVariable Integer userid, String note) {
        userService.save_note_of_user(userid,note);
    }

    @RequestMapping(value = "{userid}/note",method = RequestMethod.GET)
    @Override
    public String findPersonalNote(@PathVariable Integer userid) {
        //TODO
        //最好返回标准的json格式
        return userService.find_note_of_user(userid);
    }

    @RequestMapping(value = "{userid}/paragraph",method = RequestMethod.POST)
    @Override
    public void createPersonalParagraph(@PathVariable Integer userid,@RequestParam Integer chapter_id,@RequestParam Integer paragraph_sequence) {
        paragraphService.add_paragraph(userid,chapter_id,paragraph_sequence,"",0.0,0);
    }

    @RequestMapping(value = "{userid}/paragraph",method = RequestMethod.GET,headers = {"accept=application/json"})
    @Override
    public Paragraphs findPersonalParagraph(Integer userid) {
        List paragraphs = userService.find_all_paragraph_of_user(userid);
        return new Paragraphs(paragraphs);
    }

    @RequestMapping(value = "{userid}/paragraph",method = RequestMethod.PUT)
    @Override
    public void updatePersonalParagraph(@RequestParam Integer paragraphid,@RequestParam String content) {
        Paragraph paragraph = new Paragraph();
        paragraph.setParagraph_id(paragraphid);
        paragraph.setContent(content);
        paragraphService.update_paragraph(paragraph);
    }

    @RequestMapping(value = "{userid}/paragraph",method = RequestMethod.DELETE)
    @Override
    public void deletePersonalParagraph(@RequestParam Integer paragraphid) {
        Paragraph paragraph = new Paragraph();
        paragraph.setParagraph_id(paragraphid);
        paragraphService.delete_paragraph(paragraph);
    }

    @RequestMapping(value = "{userid}/privilege",method = RequestMethod.PUT)
    @Override
    public void chageUserPrivilege(@PathVariable Integer userid,@RequestParam boolean[] privilege) {
        //TODO
        //暂时不设置权限
    }
}
