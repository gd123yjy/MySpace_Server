package com.controllor;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yjy on 16-10-19.
 */
public interface IJournalControllor {

    public String listJournal(HttpServletRequest request, ModelMap modelMap);
    public String addJournal(HttpServletRequest request,ModelMap modelMap);
    public String deleteJournal(HttpServletRequest request,ModelMap modelMap);
    public ModelAndView editJournal(HttpServletRequest request, ModelMap modelMap);
    public String showArticle(HttpServletRequest request,ModelMap modelMap);
    public ModelAndView addParagraph(HttpServletRequest request,ModelMap modelMap);
    public ModelAndView modifyParagraph(HttpServletRequest request,ModelMap modelMap);
    public ModelAndView deleteParagraph(HttpServletRequest request,ModelMap modelMap);
}
