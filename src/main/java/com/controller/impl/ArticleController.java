package com.controller.impl;

import com.bean.Article;
import com.controller.IArticleController;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yjy on 16-10-24.
 */

@Controller
@RequestMapping(value = "/v1/article/")
public class ArticleController implements IArticleController {

    @Autowired
    private ArticleService articleService;

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public void addAritcle(int journal_id, String article_title, String article_outline) {

    }

    @Override
    public Article findAritcle(int article_id) {
        return null;
    }

    @Override
    public void updateArticle(int article_id, String article_tiltle, String article_outline) {

    }

    @Override
    public void deleteAritcle(int article_id) {

    }
}
