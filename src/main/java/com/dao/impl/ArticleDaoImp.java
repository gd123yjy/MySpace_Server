package com.dao.impl;

import com.dao.ArticleDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yjy on 16-10-26.
 */
public class ArticleDaoImp implements ArticleDao {

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    @SuppressWarnings({ "rawtypes" })
    @Override
    public List find_article_of_journal(Integer journal_id) {
        Session session = sessionFactory.openSession();
        String hql = "select article_id, title, outline from Article article where article.journal.journal_id = " + journal_id;
        List res = session.createQuery(hql).list();
        session.close();
        return res;
        //String hql = "from Article  article where article.journal.journal_id = " + journal_id;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List find_chapter_of_article(Integer article_id) {
        Session session = sessionFactory.openSession();
        String hql = "select chapter_id, title from Chapter chapter where article_id = " + article_id + " order by sequence";
        List res = session.createQuery(hql).list();
        session.close();
        return res;
    }


    @Override
    public void update_article(Integer article_id, String article_title,
                               String article_outline) {
        Session session = sessionFactory.openSession();
        String hql = "update Article article set article.title = :article_title, article.outline = :article_outline where article.article_id = :article_id";
        Query query = session.createQuery(hql);
        query.setString("article_title", article_title);
        query.setString("article_outline", article_outline);
        query.setInteger("article_id", article_id);
        query.executeUpdate();
        session.close();
    }
}
