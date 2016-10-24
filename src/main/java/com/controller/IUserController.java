package com.controller;

import com.bean.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

/**
 * Created by yjy on 16-10-23.
 */
public interface IUserController {

    //user
    public void createUser(String username, String password, String email);

    public void updateSelf(int userid, String username, String password, String email, String note);

    public User findUser(int userid);

    public void deleteUser(int userid);

    //note
    public void savePersonalNote(int userid, String note);

    public String findPersonalNote(int userid);

    //paragraph
    public void createPersonalParagraph(int userid,int chapter_id,int paragraph_sequence);

    public Paragraphs findPersonalParagraph(int userid);

    public void updatePersonalParagraph(int paragraphid,String content);

    public void deletePersonalParagraph(int paragraphid);

    //privilege
    public void chageUserPrivilege(int userid,boolean[] privilege);

}
