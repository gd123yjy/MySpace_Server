package com.controllor.impl;

import com.bean.Paragraph;
import com.controllor.IJournalControllor;
import com.service.JournalService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yjy on 16-10-19.
 */

@Controller
public class JournalControllor implements IJournalControllor {

    private static final long serialVersionUID = 113798207564591586L;

    @Autowired
    private UserService userService;
    @Autowired
    private JournalService journalService;

    @Autowired
    Integer journal_id = null;
    @Autowired
    String journal_title = null;
    @Autowired
    String ISSN = null;
    @Autowired
    Integer article_id = null;
    @Autowired
    String article_title =null;
    @Autowired
    String article_outline = null;
    @Autowired
    List articles_title = null;
    @Autowired
    List articles_outline = null;
    @Autowired
    Integer chapter_id = null;
    @Autowired
    List chapters_title = null;
    @Autowired
    Integer sequence = null;
    @Autowired
    String content = null;
    @Autowired
    Integer paragraph_id = null;
    @Autowired
    Integer userid = null;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setjournalService(JournalService service) {
        this.journalService = service;
    }

    public void setJournal_id(Integer journal_id) {
        this.journal_id = journal_id;
    }

    public void setJournal_title(String journal_title) {
        this.journal_title = journal_title;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public void setArticle_outline(String article_outline) {
        this.article_outline = article_outline;
    }

    public void setArticles_title(List articles_title) {
        this.articles_title = articles_title;
    }

    public void setArticles_outline(List articles_outline) {
        this.articles_outline = articles_outline;
    }

    public void setChapter_id(Integer chapter_id) {
        this.chapter_id = chapter_id;
    }

    public void setChapters_title(List chapters_title) {
        this.chapters_title = chapters_title;
    }

    public void setJournalService(JournalService journalService) {
        this.journalService = journalService;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setParagraph_id(Integer paragraph_id) {
        this.paragraph_id = paragraph_id;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @RequestMapping(value = "/listJournal",method = RequestMethod.GET)
    public String listJournal(HttpServletRequest request,ModelMap modelMap) {

        List journal_list = journalService.find_all();
        modelMap.put("journal_list", journal_list);

        List article_list = null;
        if (journal_list.size()==0){
            modelMap.put("article_list", article_list);
        }else {
            if (journal_id == null) {
                journal_id = (Integer)((Object[])journal_list.get(0))[0];
            }
            modelMap.put("journal_id", journal_id);
            article_list = journalService.find_article_of_journal(journal_id);
            modelMap.put("article_list", article_list);
        }

        return "Article_List";
    }

    @RequestMapping(value = "/addJournal",method = RequestMethod.POST)
    public String addJournal(HttpServletRequest request,ModelMap modelMap) {

        journalService.add_journal(journal_title, ISSN, articles_title, articles_outline, chapters_title);
        return "listJournal";
    }

    @RequestMapping(value = "/deleteJournal",method = RequestMethod.POST)
    public String deleteJournal(HttpServletRequest request,ModelMap modelMap) {
        journalService.delete_journal(journal_id);
        return "listJournal";
    }

    @RequestMapping(value = "/editJournal",method = RequestMethod.POST)
    public ModelAndView editJournal(HttpServletRequest request,ModelMap modelMap) {
        journalService.update_article(article_id, article_title, article_outline);
        modelMap.addAttribute("journal_id",journal_id);
        return new ModelAndView("listJournal",modelMap);
    }

    @RequestMapping(value = "/showArticle",method = RequestMethod.GET)
    public String showArticle(HttpServletRequest request,ModelMap modelMap) {
        List chapter_list = journalService.find_chapter_of_article(article_id);
        modelMap.put("chapter_list", chapter_list);

        if(chapter_id == null) {
            //类似于chapter_id = ((Chapter)chapter_list.get(0)).getChapter_id();
            //但不是等价于
            chapter_id = (Integer)((Object[])chapter_list.get(0))[0];
        }
        modelMap.put("paragraph_list", journalService.find_paragraph_of_article(chapter_id));
        modelMap.put("note", userService.find_note_of_user(userid));
        return "Article2";
    }

    @RequestMapping(value = "/addParagraph",method = RequestMethod.POST)
    public ModelAndView addParagraph(HttpServletRequest request,ModelMap modelMap) {
        if (userid == null) {
            modelMap.addAttribute("message", "您还木有登录啦！");
            return new ModelAndView("welcome",modelMap);
        }
        journalService.add_paragraph(userid, chapter_id, sequence, content, 1.0, 1);
        modelMap.addAttribute("article_id",article_id);
        modelMap.addAttribute("chapter_id",chapter_id);
        return new ModelAndView("showArticle",modelMap);
    }

    @RequestMapping(value = "/modifyParagraph",method = RequestMethod.POST)
    public ModelAndView modifyParagraph(HttpServletRequest request,ModelMap modelMap) {
        Paragraph paragraph = journalService.find_paragraph_by_paragraph_id(paragraph_id);
        if (paragraph==null){
            modelMap.addAttribute("message", "找不到您要修改的段落！");
            return new ModelAndView("message",modelMap);
        }
        if (userid == null){
            modelMap.addAttribute("message", "您尚未登陆！");
            return new ModelAndView("message",modelMap);
        }
        if (userid != paragraph.getUser().getUserid()) {
            modelMap.addAttribute("message", "这段东西又不是你写的，不能改它！");
            return new ModelAndView("welcome",modelMap);
        }
        paragraph.setContent(content);
        journalService.update_paragraph(paragraph);
        return new ModelAndView("userManage",modelMap);
    }

    @RequestMapping(value = "/deleteParagraph",method = RequestMethod.POST)
    public ModelAndView deleteParagraph(HttpServletRequest request,ModelMap modelMap) {
        Paragraph paragraph = journalService.find_paragraph_by_paragraph_id(paragraph_id);
        if (userid != paragraph.getUser().getUserid()) {
            modelMap.addAttribute("message", "这段东西又不是你写的，不能改它！");
            return new ModelAndView("welcome",modelMap);
        }
        journalService.delete_paragraph(paragraph);
        return new ModelAndView("userManage",modelMap);
    }

}
