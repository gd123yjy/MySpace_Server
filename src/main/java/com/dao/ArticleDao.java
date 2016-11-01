package com.dao;

import java.util.List;

/**
 * Created by yjy on 16-10-26.
 */
public interface ArticleDao {

    @SuppressWarnings("rawtypes")
    public List find_article_of_journal(Integer journal_id);

    @SuppressWarnings("rawtypes")
    public List find_chapter_of_article(Integer article_id);

    public void update_article(Integer article_id, String article_title, String article_outline);
}
