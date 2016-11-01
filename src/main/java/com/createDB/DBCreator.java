package com.createDB;

import com.bean.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Created by yjy on 16-9-11.
 */
public class DBCreator {
    public static void main(String[] arg){
        //创建关系
        Configuration configuration = new Configuration().configure();
        SchemaExport schemaExport = new SchemaExport(configuration);
        schemaExport.create(true,true);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        //创建管理员
        Transaction transaction=session.beginTransaction();
        User user = new User();
        user.setAdmin(true);
        user.setEmail("1234567@163.com");
        user.setPassword("111111");
        user.setUsername("root");
        session.save(user);

        //创建初始杂志
        Journal journal = new Journal();
        journal.setISSN("1234-5678");
        journal.setJournal_title("initial journal");

        Article article = new Article();
        article.setOutline("article-outline");
        article.setTitle("initial article");
        article.setJournal(journal);

        Chapter chapter = new Chapter();
        chapter.setSequence(0);
        chapter.setTitle("initial chapter");
        chapter.setArticle(article);

        Paragraph paragraph = new Paragraph();
        paragraph.setSequence(0);
        paragraph.setContent("this is the initial paragraph");
        paragraph.setScore_num(0);
        paragraph.setScore(0.0);
        paragraph.setUser(user);
        paragraph.setChapter(chapter);

        session.save(journal);
        session.save(article);
        session.save(chapter);
        session.save(paragraph);

        //提交事务
        transaction.commit();
        //关闭数据库连接
        if (session.isOpen()){
            session.close();
        }
        return;
    }
}
