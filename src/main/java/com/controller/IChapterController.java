package com.controller;

import com.bean.Chapter;

/**
 * Created by yjy on 16-10-24.
 */
public interface IChapterController {

    //chapter
    public void addChapter(Integer article_id,String chapter_title );

    public Chapter findChapter(Integer chapter_id);

    public void updateChapter(Integer chapter_id,String chapter_tiltle);

    public void deleteChapter(Integer chapter_id);
}
