package com.dao;

import com.bean.Chapter;
import com.bean.Paragraph;

import java.util.List;

/**
 * Created by yjy on 16-10-26.
 */
public interface ChapterDao {

    public List<List<Paragraph>> find_paragraph_of_chapter(Integer chapter_id);

    public void add_chapter(Chapter chapter);

    Chapter find_chapter(Integer chapter_id);

    void update_chapter(Chapter chapter);

    void delet_chapte(Chapter chapter);
}
