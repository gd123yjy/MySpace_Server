package com.service.impl;

import com.dao.ChapterDao;
import com.service.ChapterService;

/**
 * Created by yjy on 16-10-24.
 */
public class ChapterServiceImp implements ChapterService {

    private ChapterDao chapterDao;

    public void setChapterDao(ChapterDao chapterDao) {
        this.chapterDao = chapterDao;
    }
}
