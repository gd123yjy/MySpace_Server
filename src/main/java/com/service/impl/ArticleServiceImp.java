package com.service.impl;

import com.bean.Article;
import com.bean.Paragraph;
import com.dao.ArticleDao;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yjy on 16-10-24.
 */

@Service
@Transactional
public class ArticleServiceImp implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

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
    public void update_article(Integer article_id, String article_title,
                               String article_outline) {
        articleDao.update_article(article_id, article_title, article_outline);
    }

    @Override
    public void add_article(Article article) {
        articleDao.add_article(article);
    }

    @Override
    public Article find_article_by_id(Integer article_id) {
        return articleDao.find_article_by_id(article_id);
    }

    @Override
    public void update_article(Article article) {
        articleDao.update_article(article.getArticle_id(),article.getTitle(),article.getOutline());
    }

    @Override
    public void delete_article(Integer article_id) {
        articleDao.delete_article(article_id);
    }


}
