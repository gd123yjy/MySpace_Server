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
    public Journals listJournal(int limits);

    //journal
    public Journal findJournal(int journal_id);

    public String addJournal(String journal_title, String ISSN);

    public String deleteJournal(int journal_id);

    public String updateJournal(int journal_id, int article_id, String article_title, String article_outline);

    //article
    public Article showArticle(int journal_id,int article_id, @ModelAttribute int chapter_id, @ModelAttribute int userid);

    public String addParagraph(@ModelAttribute int userid,@ModelAttribute int article_id,@ModelAttribute int chapter_id,@ModelAttribute int sequence,@ModelAttribute String content);

    public String modifyParagraph(@ModelAttribute int paragraph_id,@ModelAttribute int userid,@ModelAttribute String content);

    public String deleteParagraph(@ModelAttribute int paragraph_id,@ModelAttribute int userid);

}
