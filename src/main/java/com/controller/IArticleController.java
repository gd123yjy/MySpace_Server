package com.controller;

import com.bean.Article;
import com.bean.Articles;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yjy on 16-10-24.
 */
public interface IArticleController {

    //article
    public void addArticle(Integer journal_id, String article_title, String article_outline);

    @RequestMapping(value = "",method = RequestMethod.POST)
    void addArticle(@RequestBody Article article);

    public Article findArticle(Integer article_id);

    public void updateArticle(Integer article_id,String article_tiltle,String article_outline);

    @RequestMapping(value = "{article_id}",method = RequestMethod.PUT)
    void updateArticle(@PathVariable Integer article_id,@RequestBody Article article);

    public void deleteArticle(Integer article_id);

    public Articles findArticleOfJournal(Integer journal_id);

}
