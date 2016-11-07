package com.controller.impl;

import com.bean.Article;
import com.bean.Chapter;
import com.controller.IChapterController;
import com.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yjy on 16-10-24.
 */

@RestController
@RequestMapping(value = "v1/chapter/")
public class ChapterController implements IChapterController{

    @Autowired
    private ChapterService chapterService;

    public void setChapterService(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @Override
    public void addChapter(@RequestParam Integer article_id,@RequestParam String chapter_title) {
        Chapter chapter = new Chapter();
        Article article = new Article();
        article.setArticle_id(article_id);
        chapter.setArticle(article);
        chapter.setTitle(chapter_title);
        chapterService.add_chapter(chapter);
    }

    @RequestMapping(value = "{chapter_id}",method = RequestMethod.GET,headers = {"accept=application/json"})
    @Override
    public Chapter findChapter(@PathVariable Integer chapter_id) {
        return chapterService.find_chapter(chapter_id);
    }

    @RequestMapping(value = "{chapter_id}",method = RequestMethod.PUT)
    @Override
    public void updateChapter(@PathVariable Integer chapter_id,@RequestParam(required = false) String chapter_tiltle) {
        Chapter chapter = new Chapter();
        chapter.setChapter_id(chapter_id);
        chapter.setTitle(chapter_tiltle);
        chapterService.update_chapter(chapter);
    }

    @RequestMapping(value = "{chapter_id}",method = RequestMethod.DELETE)
    @Override
    public void deleteChapter(@PathVariable Integer chapter_id) {
        Chapter chapter = new Chapter();
        chapter.setChapter_id(chapter_id);
        chapterService.delte_chapter(chapter);
    }
}
