package com.dao.impl;

import com.bean.Paragraph;
import com.dao.ParagraphDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yjy on 16-10-26.
 */
public class ParagraphDapImp implements ParagraphDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add_paragraph(Paragraph paragraph) {
        Session session = sessionFactory.openSession();
        session.save(paragraph);
        session.close();
    }

    @Override
    public Paragraph find_paragraph_by_paragraph_id(Integer paragraph_id) {
        Session session = sessionFactory.openSession();
        String hql = "from Paragraph paragraph where paragraph_id = " + paragraph_id;
        Query query = session.createQuery(hql);
        Paragraph paragraph = (Paragraph)query.uniqueResult();
        session.close();
        return paragraph;
    }

    @Override
    public void update_paragraph(Paragraph paragraph) {
        Session session = sessionFactory.openSession();
        session.update(paragraph);
        session.flush();
        session.close();
    }

    @Override
    public void delete_paragraph(Paragraph paragraph) {
        Session session = sessionFactory.openSession();
        String hql = "delete from Paragraph paragraph where paragraph_id = " + paragraph.getParagraph_id();
        Query query = session.createQuery(hql);
        query.executeUpdate();
        session.close();
    }
}
