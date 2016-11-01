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

    public void updateSelf(Integer userid, String username, String password, String email, String note);

    public User findUser(Integer userid);

    public void deleteUser(Integer userid);

    //note
    public void savePersonalNote(Integer userid, String note);

    public String findPersonalNote(Integer userid);

    //paragraph
    public void createPersonalParagraph(Integer userid,Integer chapter_id,Integer paragraph_sequence);

    public Paragraphs findPersonalParagraph(Integer userid);

    public void updatePersonalParagraph(Integer paragraphid,String content);

    public void deletePersonalParagraph(Integer paragraphid);

    //privilege
    public void chageUserPrivilege(Integer userid,boolean[] privilege);

}
