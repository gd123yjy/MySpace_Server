package com.controllor;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yjy on 16-10-19.
 */
public interface IJournalControllor {

    public String listJournal(int journal_id, ModelMap modelMap);
    public String addJournal( String journal_title, String ISSN,  List<String> articles_title,  List<String> articles_outline, List<String> chapters_title, ModelMap modelMap);
    public String deleteJournal(int journal_id,ModelMap modelMap);
    public ModelAndView editJournal(int journal_id,int article_id,String article_title,String article_outline,ModelMap modelMap);
    public String showArticle(@ModelAttribute int article_id, @ModelAttribute int chapter_id,@ModelAttribute int userid, ModelMap modelMap);
    public ModelAndView addParagraph(@ModelAttribute int userid,@ModelAttribute int article_id,@ModelAttribute int chapter_id,@ModelAttribute int sequence,@ModelAttribute String content,ModelMap modelMap);
    public ModelAndView modifyParagraph(@ModelAttribute int paragraph_id,@ModelAttribute int userid,@ModelAttribute String content,ModelMap modelMap);
    public ModelAndView deleteParagraph(@ModelAttribute int paragraph_id,@ModelAttribute int userid,ModelMap modelMap);
}
