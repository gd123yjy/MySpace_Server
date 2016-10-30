package com.controller;

import com.bean.Article;
import com.bean.Journal;
import com.bean.Journals;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by yjy on 16-10-19.
 */
public interface IJournalController {

    //journals
    public Journals listJournal(Integer startpoint,Integer limits);

    //journal
    public void addJournal(Integer userid,String journal_title, String ISSN);

    public Journal findJournal(Integer journal_id);

    public void deleteJournal(Integer journal_id);

    public void updateJournal(Integer journal_id, String journal_title, String ISSN);

    @RequestMapping(value = "{journal_id}",method = RequestMethod.PATCH)
    void patchJournal(@PathVariable Integer journal_id, @RequestParam(required = false) String journal_title, @RequestParam(required = false) String ISSN);
}
