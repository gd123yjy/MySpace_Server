package com.controller.impl;

import com.bean.Article;
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


}
