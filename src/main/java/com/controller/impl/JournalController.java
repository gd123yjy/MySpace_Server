package com.controller.impl;

import com.bean.Article;
import com.bean.Journal;
import com.bean.Journals;
import com.bean.Paragraph;
import com.controller.IJournalController;
import com.service.JournalService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by yjy on 16-10-19.
 */

@Controller()
@RequestMapping(value = "/v1/journal/")
public class JournalController implements IJournalController {

    private static final long serialVersionUID = 113798207564591586L;

    @Autowired
    private JournalService journalService;

    public void setjournalService(JournalService service) {
        this.journalService = service;
    }


    @Override
    public Journals listJournal(int startpoint, int limits) {
        return null;
    }

    @Override
    public void addJournal(int userid, String journal_title, String ISSN) {

    }

    @Override
    public Journal findJournal(int journal_id) {
        return null;
    }

    @Override
    public void deleteJournal(int journal_id) {

    }

    @Override
    public void updateJournal(int journal_id, String journal_title, String ISSN) {

    }
}
