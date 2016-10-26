package com.service;

import com.bean.Paragraph;

import java.util.List;

/**
 * Created by yjy on 16-10-24.
 */
public interface ChapterService {

    public List<List<Paragraph>> find_paragraph_of_chapter(Integer chapter_id);
}
