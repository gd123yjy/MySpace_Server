package com.controller.impl;

import com.bean.Paragraph;
import com.controller.IParagraphController;
import com.service.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "",method = RequestMethod.POST)
    @Override
    public void addParagraph(@RequestParam int userid,@RequestParam int chapter_id,@RequestParam int sequence, String content) {
//TODO

    }

    @RequestMapping(value = "{paragraph_id}",method = RequestMethod.GET)
    @Override
    public Paragraph findParagraph(@PathVariable int paragraph_id) {
        //TODO
        return null;
    }

    @RequestMapping(value = "{paragraph_id}",method = RequestMethod.PUT)
    @Override
    public void updateParagraph(@PathVariable int paragraph_id,@RequestParam(required = false) String content) {
//TODO

    }

    @RequestMapping(value = "{paragraph_id}",method = RequestMethod.DELETE)
    @Override
    public void deleteParagraph(@PathVariable int paragraph_id) {
//TODO

    }
}
