package com.service;

import com.bean.Chapter;
import com.bean.Paragraph;

import java.util.List;

/**
 * Created by yjy on 16-10-24.
 */
public interface ChapterService {

    public List<List<Paragraph>> find_paragraph_of_chapter(Integer chapter_id);

    void add_chapter(Chapter chapter);

    Chapter find_chapter(Integer chapter_id);

    void update_chapter(Chapter chapter);

    void delte_chapter(Chapter chapter);
}
