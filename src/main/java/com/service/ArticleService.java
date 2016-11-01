package com.service;

import com.bean.Article;
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

    void add_article(Article article);

    Article find_article_by_id(Integer article_id);

    void update_article(Article article);

    void delete_article(Integer article_id);
}
