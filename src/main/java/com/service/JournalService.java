package com.service;

import java.util.List;

import com.bean.Paragraph;

public interface JournalService {

	@SuppressWarnings("rawtypes")
	public List find_all();

	public List<String> find_all_title();

	//no use
	public Integer find_first_journal_id();

	public void add_journal(String journal_title, String ISSN,List<String> articles_title,
			List<String> articles_outline, List<String> chapters_title);

	public void delete_journal(Integer journal_id);

}
