package com.controller.impl;

import com.bean.Paragraph;
import com.controller.IParagraphController;
import com.service.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yjy on 16-10-24.
 */

@Controller
@RequestMapping(value = "/v1/paragraph/")
public class ParagraphController implements IParagraphController{

    @Autowired
    private ParagraphService paragraphService;

    public void setParagraphService(ParagraphService paragraphService) {
        this.paragraphService = paragraphService;
    }

    @Override
    public void addParagraph(int userid, int chapter_id, int sequence, String content) {

    }

    @Override
    public Paragraph findParagraph(int paragraph_id) {
        return null;
    }

    @Override
    public void updateParagraph(int paragraph_id, String content) {

    }

    @Override
    public void deleteParagraph(int paragraph_id) {

    }
}
