package com.controller.impl;

import com.bean.Article;
import com.bean.Articles;
import com.controller.IArticleController;
import com.service.ArticleService;
import com.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yjy on 16-10-24.
 */

@RestController
@RequestMapping(value = "v1/article")
public class ArticleController implements IArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private JournalService journalService;

    //TODO
    //@RequestMapping(value = "",method = RequestMethod.POST)
    @Override
    public void addArticle(@RequestParam Integer journal_id, @RequestParam String article_title, @RequestParam String article_outline) {
        Article article = new Article();
        article.setJournal(journalService.findJournal(journal_id));
        article.setTitle(article_title);
        article.setOutline(article_outline);
        articleService.add_article(article);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @Override
    public void addArticle(@RequestBody Article article) {
        articleService.add_article(article);
    }

    @RequestMapping(value = "{article_id}",method = RequestMethod.GET,headers = {"accept=application/json"})
    @Override
    public Article findArticle(@PathVariable Integer article_id) {
        Article article = articleService.find_article_by_id(article_id);
        return article;
    }

    //@RequestMapping(value = "{article_id}",method = RequestMethod.PUT)
    @Override
    public void updateArticle(@PathVariable Integer article_id,@RequestParam(required = false) String article_tiltle,@RequestParam(required = false) String article_outline) {
        Article article = new Article();
        article.setArticle_id(article_id);
        article.setTitle(article_tiltle);
        article.setOutline(article_outline);
        articleService.update_article(article);
    }

    @RequestMapping(value = "{article_id}",method = RequestMethod.PUT)
    @Override
    public void updateArticle(@PathVariable Integer article_id,@RequestBody Article article) {
        article.setArticle_id(article_id);
        articleService.update_article(article);
    }

    @RequestMapping(value = "{article_id}",method = RequestMethod.DELETE)
    @Override
    public void deleteArticle(@PathVariable Integer article_id) {
        articleService.delete_article(article_id);
    }

    @RequestMapping(value = "",method = RequestMethod.GET,headers = {"accept=application/json"})
    @Override
    public @ResponseBody Articles findArticleOfJournal(@RequestParam Integer journal_id) {
        List<Article> articles = articleService.find_article_of_journal(journal_id);
        return new Articles(articles);
    }
}
