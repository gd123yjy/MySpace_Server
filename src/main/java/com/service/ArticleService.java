package com.service;

import com.bean.Paragraph;

import java.util.List;

/**
 * Created by yjy on 16-10-24.
 */
public interface ArticleService {

    @SuppressWarnings("rawtypes")
    public List find_article_of_journal(Integer journal_id);

    @SuppressWarnings("rawtypes")
    public List find_chapter_of_article(Integer article_id);

    public void update_article(Integer article_id, String article_title, String article_outline);
}
