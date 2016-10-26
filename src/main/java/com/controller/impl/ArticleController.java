package com.controller.impl;

import com.bean.Article;
import com.controller.IArticleController;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "",method = RequestMethod.POST)
    @Override
    public void addArticle(@RequestParam int journal_id, @RequestParam String article_title, @RequestParam String article_outline) {
//TODO

    }

    @RequestMapping(value = "{article_id}",method = RequestMethod.GET)
    @Override
    public Article findArticle(@PathVariable int article_id) {
        //TODO
        return null;
    }

    @RequestMapping(value = "{article_id}",method = RequestMethod.PUT)
    @Override
    public void updateArticle(@PathVariable int article_id,@RequestParam(required = false) String article_tiltle,@RequestParam(required = false) String article_outline) {
//TODO

    }

    @RequestMapping(value = "{article_id}",method = RequestMethod.DELETE)
    @Override
    public void deleteArticle(@PathVariable int article_id) {
//TODO

    }
}
