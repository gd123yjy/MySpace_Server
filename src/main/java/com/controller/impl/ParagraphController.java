package com.controller.impl;

import com.bean.Paragraph;
import com.controller.IParagraphController;
import com.service.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yjy on 16-10-24.
 */

@RestController
@RequestMapping(value = "v1/paragraph")
public class ParagraphController implements IParagraphController {

    @Autowired
    private ParagraphService paragraphService;

    public void setParagraphService(ParagraphService paragraphService) {
        this.paragraphService = paragraphService;
    }

    @RequestMapping(value = {"","/"}, method = RequestMethod.POST)
    @Override
    public void addParagraph(@RequestParam Integer userid, @RequestParam Integer chapter_id, @RequestParam Integer sequence, String content) {
        //TODO
        //score部分有待完善
        paragraphService.add_paragraph(userid,chapter_id,sequence,content,0.0,0);
    }

    @RequestMapping(value = "{paragraph_id}", method = RequestMethod.GET,headers = {"accept=application/json"})
    @Override
    public Paragraph findParagraph(@PathVariable Integer paragraph_id) {
        return paragraphService.find_paragraph_by_paragraph_id(paragraph_id);
    }

    @RequestMapping(value = "{paragraph_id}", method = RequestMethod.PUT)
    @Override
    public void updateParagraph(@PathVariable Integer paragraph_id, @RequestParam(required = false) String content) {
        Paragraph paragraph = new Paragraph();
        paragraph.setParagraph_id(paragraph_id);
        paragraph.setContent(content);
        paragraphService.update_paragraph(paragraph);
    }

    @RequestMapping(value = "{paragraph_id}", method = RequestMethod.DELETE)
    @Override
    public void deleteParagraph(@PathVariable Integer paragraph_id) {
        Paragraph paragraph = new Paragraph();
        paragraph.setParagraph_id(paragraph_id);
        paragraphService.delete_paragraph(paragraph);
    }
}
