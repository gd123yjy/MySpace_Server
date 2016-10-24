package com.controller;

import com.bean.Article;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by yjy on 16-10-24.
 */
public interface IArticleController {

    //article
    public void addAritcle(int journal_id, String article_title, String article_outline);

    public Article findAritcle(int article_id);

    public void updateArticle(int article_id,String article_tiltle,String article_outline);

    public void deleteAritcle(int article_id);

}
