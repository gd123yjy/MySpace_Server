package com.controller.impl;

import com.bean.Chapter;
import com.controller.IChapterController;
import com.service.ChapterService;
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
@RequestMapping(value = "v1/chapter/")
public class ChapterController implements IChapterController{

    @Autowired
    private ChapterService chapterService;

    public void setChapterService(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @Override
    public void addChapter(@RequestParam int article_id,@RequestParam String chapter_title) {
//TODO

    }

    @RequestMapping(value = "{chapter_id}",method = RequestMethod.GET)
    @Override
    public Chapter findChapter(@PathVariable int chapter_id) {
        //TODO
        return null;
    }

    @RequestMapping(value = "{chapter_id}",method = RequestMethod.PUT)
    @Override
    public void updateChapter(@PathVariable int chapter_id,@RequestParam(required = false) String chapter_tiltle) {
//TODO

    }

    @RequestMapping(value = "{chapter_id}",method = RequestMethod.DELETE)
    @Override
    public void deleteChapter(@PathVariable int chapter_id) {
//TODO

    }
}
