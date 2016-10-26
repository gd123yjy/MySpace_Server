package com.service.impl;

import com.bean.Paragraph;
import com.dao.ChapterDao;
import com.service.ChapterService;

import java.util.List;

/**
 * Created by yjy on 16-10-24.
 */
public class ChapterServiceImp implements ChapterService {

    private ChapterDao chapterDao;

    public void setChapterDao(ChapterDao chapterDao) {
        this.chapterDao = chapterDao;
    }

    @Override
    public List<List<Paragraph>> find_paragraph_of_chapter(Integer chapter_id) {
        return chapterDao.find_paragraph_of_chapter(chapter_id);
    }
}
