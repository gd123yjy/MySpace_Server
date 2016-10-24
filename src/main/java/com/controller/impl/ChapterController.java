package com.controller.impl;

import com.bean.Chapter;
import com.controller.IChapterController;
import com.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yjy on 16-10-24.
 */

@Controller
@RequestMapping(value = "/v1/chapter/")
public class ChapterController implements IChapterController{

    @Autowired
    private ChapterService chapterService;

    public void setChapterService(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @Override
    public void addChapter(int article_id, String chapter_title) {

    }

    @Override
    public Chapter findChapter(int chapter_id) {
        return null;
    }

    @Override
    public void updateChapter(int chapter_id, String chapter_tiltle) {

    }

    @Override
    public void deleteChapter(int chapter_id) {

    }
}
