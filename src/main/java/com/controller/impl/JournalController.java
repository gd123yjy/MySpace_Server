package com.controller.impl;

import com.bean.Article;
import com.bean.Journal;
import com.bean.Journals;
import com.bean.Paragraph;
import com.controller.IJournalController;
import com.service.ArticleService;
import com.service.JournalService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;

/**
 * Created by yjy on 16-10-19.
 */

@RestController
@RequestMapping(value = "v1/journal")
public class JournalController implements IJournalController {

    private static final long serialVersionUID = 113798207564591586L;

    @Autowired
    private JournalService journalService;

    @Autowired
    private ArticleService articleService;

    public void setjournalService(JournalService service) {
        this.journalService = service;
    }


    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = {"","/"},method = RequestMethod.GET,headers = {"accept=application/json"})
    @Override
    public Journals listJournal(@RequestParam(required = false) Integer startpoint,@RequestParam(required = false) Integer limits) {
        //TODO
        //暂时设置为不级联搜素article
        List<Journal> journal = journalService.find_all();
        return new Journals(journal);
    }

    @RequestMapping(value = {"","/"},method = RequestMethod.POST)
    @Override
    public void addJournal(Integer userid, String journal_title, String ISSN) {
        journalService.add_journal(journal_title,ISSN);
    }

    @RequestMapping(value = "{journal_id}",method = RequestMethod.GET,headers = {"accept=application/json"})
    @Override
    public Journal findJournal(@PathVariable Integer journal_id) {
        Journal journal = journalService.findJournal(journal_id);
        List articles = articleService.find_article_of_journal(journal_id);
        journal.setArticles(new HashSet<Article>(articles));
        return journal;
    }

    @RequestMapping(value = "{journal_id}",method = RequestMethod.DELETE)
    @Override
    public void deleteJournal(@PathVariable Integer journal_id) {
        journalService.delete_journal(journal_id);
    }

    @RequestMapping(value = "{journal_id}",method = RequestMethod.PUT)
    @Override
    public void updateJournal(@PathVariable Integer journal_id,@RequestParam(required = true) String journal_title,@RequestParam(required = true) String ISSN) {
        Journal journal = new Journal();
        journal.setJournal_id(journal_id);
        journal.setJournal_title(journal_title);
        journal.setISSN(ISSN);
        journalService.update_journal(journal);
    }

    @RequestMapping(value = "{journal_id}",method = RequestMethod.PATCH)
    @Override
    public void patchJournal(@PathVariable Integer journal_id,@RequestParam(required = false) String journal_title,@RequestParam(required = false) String ISSN) {
        //TODO
        Journal journal = new Journal();
        journal.setJournal_id(journal_id);
        journal.setJournal_title(journal_title);
        journal.setISSN(ISSN);
        journalService.update_journal(journal);
    }
}
