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
}
