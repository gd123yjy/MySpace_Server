package com.controller;

import com.bean.Article;
import com.bean.Journal;
import com.bean.User;
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
    public String createUser(String username, String password, String email);

    public void updateUser(int userid, String username, String password, String email, String note);

    public User findUser(int userid);

    public void deleteUser(int userid);

    //note
    public void saveNote(int userid, String note);

    public String findNote(int userid);

    //paragraph
    public String findPersonalParagraph(int userid);

    public String updatePersonalParagraph(int userid,int paragraphid,String content);

    public String deletePersonalParagraph(int userid,int paragraphid);

    //privilege
    public String chageUserPrivilege(int managerid,int accessorid,boolean[] privilege);

}
