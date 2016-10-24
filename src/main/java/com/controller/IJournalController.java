package com.controller;

import com.bean.Article;
import com.bean.Journal;
import com.bean.Journals;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by yjy on 16-10-19.
 */
public interface IJournalController {

    //journals
    public Journals listJournal(int startpoint,int limits);

    //journal
    public void addJournal(int userid,String journal_title, String ISSN);

    public Journal findJournal(int journal_id);

    public void deleteJournal(int journal_id);

    public void updateJournal(int journal_id, String journal_title, String ISSN);

}
