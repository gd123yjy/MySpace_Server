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
@RequestMapping(value = "v1/journal/")
public class JournalController implements IJournalController {

    private static final long serialVersionUID = 113798207564591586L;

    @Autowired
    private JournalService journalService;

    public void setjournalService(JournalService service) {
        this.journalService = service;
    }


    @RequestMapping(value = "",method = RequestMethod.GET)
    @Override
    public @ResponseBody Journals listJournal(int startpoint, int limits) {
        //TODO
        return null;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @Override
    public void addJournal(int userid, String journal_title, String ISSN) {
//TODO
    }

    @RequestMapping(value = "{journal_id}",method = RequestMethod.GET)
    @Override
    public @ResponseBody Journal findJournal(@PathVariable int journal_id) {
        //TODO
        return null;
    }

    @RequestMapping(value = "{journal_id}",method = RequestMethod.DELETE)
    @Override
    public void deleteJournal(@PathVariable int journal_id) {
//TODO

    }

    @RequestMapping(value = "{journal_id}",method = RequestMethod.PUT)
    @Override
    public void updateJournal(@PathVariable int journal_id,@RequestParam(required = false) String journal_title,@RequestParam(required = false) String ISSN) {
//TODO

    }
}
