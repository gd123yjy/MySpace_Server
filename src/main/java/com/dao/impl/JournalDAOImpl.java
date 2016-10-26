package com.dao.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.bean.Journal;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.Chapter;
import com.bean.Paragraph;
import com.dao.JournalDAO;
import org.hibernate.Transaction;

public class JournalDAOImpl implements JournalDAO {

	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public List find_all_journal() {
		Session session = sessionFactory.openSession();
		String hql = "select journal.journal_id, journal.journal_title, journal.ISSN from Journal journal order by journal.journal_id desc";
		List res = session.createQuery(hql).list();
		session.close();
		return res;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> find_all_journal_title() {
		Session session = sessionFactory.openSession();
		String hql = "select journal_title from Journal journal order by journal.journal_id desc";
		List<String> res = session.createQuery(hql).list();
		session.close();
		return res;
	}

	@Override
	public Integer find_first_journal_id() {
		Session session = sessionFactory.openSession();
		String hql = "select journal_id from Journal journal order by journal.journal_id desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Integer res = (Integer)query.list().get(0);
		session.close();
		return res;
	}



	@Override
	public void delete_journal(Integer journal_id) {
		Session session = sessionFactory.openSession();
		//删除相关的articles
		//List list = find_article_of_journal(journal_id);

		//删除journal
		Transaction t = session.beginTransaction();
//		String hql = "delete from Journal journal where journal_id = " + journal_id;
//		Query query = session.createQuery(hql);
//		query.executeUpdate();
		Journal journal = (Journal) session.get(Journal.class,journal_id);
		session.delete(journal);
		t.commit();
		session.close();
	}


}
