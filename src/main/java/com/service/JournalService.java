package com.service;

import java.util.List;

import com.bean.Journal;
import com.bean.Paragraph;

public interface JournalService {

	@SuppressWarnings("rawtypes")
	public List find_all();

	public List<String> find_all_title();

	//no use
	public Integer find_first_journal_id();

	public void add_journal(String journal_title, String ISSN);

	public void delete_journal(Integer journal_id);

    Journal findJournal(Integer journal_id);

    void update_journal(Journal journal);
}
