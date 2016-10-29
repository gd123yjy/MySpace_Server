package com.controller.impl;

import com.bean.Article;
import com.bean.Articles;
import com.controller.IArticleController;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yjy on 16-10-24.
 */

@Controller
@RequestMapping(value = "v1/article/")
public class ArticleController implements IArticleController {

    @Autowired
    private ArticleService articleService;

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @Override
    public void addArticle(@RequestParam Integer journal_id, @RequestParam String article_title, @RequestParam String article_outline) {
//TODO

    }

    @RequestMapping(value = "{article_id}",method = RequestMethod.GET)
    @Override
    public @ResponseBody Article findArticle(@PathVariable Integer article_id) {
        //TODO
        return null;
    }

    @RequestMapping(value = "{article_id}",method = RequestMethod.PUT)
    @Override
    public void updateArticle(@PathVariable Integer article_id,@RequestParam(required = false) String article_tiltle,@RequestParam(required = false) String article_outline) {
//TODO

    }

    @RequestMapping(value = "{article_id}",method = RequestMethod.DELETE)
    @Override
    public void deleteArticle(@PathVariable Integer article_id) {
//TODO

    }

    @Override
    public @ResponseBody Articles findArticleOfJournal(Integer journal_id) {
        //TODO
        return null;
    }
}
