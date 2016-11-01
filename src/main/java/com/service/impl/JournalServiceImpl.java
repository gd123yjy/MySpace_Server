package com.service.impl;

import java.util.List;

import com.bean.Article;
import com.bean.Chapter;
import com.bean.Journal;
import com.bean.Paragraph;
import com.bean.User;
import com.dao.JournalDAO;
import com.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JournalServiceImpl implements JournalService {

    @Autowired
	private JournalDAO journalDAO;
	
	public void setJournalDAO(JournalDAO journalDAO) {
		this.journalDAO = journalDAO;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List find_all() {
		return journalDAO.find_all_journal();
	}
	
	
	@Override
	public List<String> find_all_title() {
		return journalDAO.find_all_journal_title();
	}

	@Override
	public Integer find_first_journal_id() {
		return journalDAO.find_first_journal_id();
	}

	@Override
	public void add_journal(String journal_title, String ISSN/*,List<String> articles_title,
			List<String> articles_outline, List<String> chapters_title*/) {
		Journal journal = new Journal();
		journal.setJournal_title(journal_title);
		journal.setISSN(ISSN);
		/*int cur_chapter_title_index = 0;
		for (int i = 0; i < articles_title.size(); ++i) {
			Article article = new Article();
			article.setJournal(journal);
			article.setTitle(articles_title.get(i));
			article.setOutline(articles_outline.get(i));
			for (int j = 0; j < chapters_title.size() / articles_title.size(); ++j, ++cur_chapter_title_index) {
				Chapter chapter = new Chapter();
				chapter.setArticle(article);
				chapter.setTitle(chapters_title.get(cur_chapter_title_index));
				chapter.setSequence(j);
				journalDAO.add_chapter(chapter);
			}
		}*/
		journalDAO.save_journal(journal);
	}

	@Override
	public void delete_journal(Integer journal_id) {
		journalDAO.delete_journal(journal_id);
		
	}

	@Override
	public Journal findJournal(Integer journal_id) {
		return journalDAO.findJournal(journal_id);
	}

	@Override
	public void update_journal(Journal journal) {
		journalDAO.save_journal(journal);
	}

}
