package com.controller;

import com.bean.Chapter;

/**
 * Created by yjy on 16-10-24.
 */
public interface IChapterController {

    //chapter
    public void addChapter(int article_id,String chapter_title );

    public Chapter findChapter(int chapter_id);

    public void updateChapter(int chapter_id,String chapter_tiltle);

    public void deleteChapter(int chapter_id);
}
