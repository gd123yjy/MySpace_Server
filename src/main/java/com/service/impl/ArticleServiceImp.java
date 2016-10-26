package com.service.impl;

import com.bean.Paragraph;
import com.dao.ArticleDao;
import com.service.ArticleService;

import java.util.List;

/**
 * Created by yjy on 16-10-24.
 */
public class ArticleServiceImp implements ArticleService {

    private ArticleDao articleDao;

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List find_article_of_journal(Integer journal_id) {
        return articleDao.find_article_of_journal(journal_id);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List find_chapter_of_article(Integer article_id) {
        return articleDao.find_chapter_of_article(article_id);
    }

    @Override
    public List<List<Paragraph>> find_paragraph_of_article(Integer chapter_id) {
        return articleDao.find_paragraph_of_chapter(chapter_id);
    }

    @Override
    public void update_article(Integer article_id, String article_title,
                               String article_outline) {
        articleDao.update_article(article_id, article_title, article_outline);

    }

}
