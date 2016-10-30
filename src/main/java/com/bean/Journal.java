package com.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;
import java.util.Set;

@XmlType(name = "journal")
public class Journal {
	@XmlElement(name = "journal_id")
	private Integer journal_id;
	@XmlElement(name = "journal_title")
	private String journal_title;
	@XmlElement(name = "ISSN")
	private String ISSN;
    @XmlElementWrapper(name = "article")
	//@XmlElement(name = "article")
	private Set<Article> articles = new HashSet<Article>();
	
	
	public String getISSN() {
		return ISSN;
	}
	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}
	public String getJournal_title() {
		return journal_title;
	}
	public void setJournal_title(String journal_title) {
		this.journal_title = journal_title;
	}
	public Integer getJournal_id() {
		return journal_id;
	}
	public void setJournal_id(Integer journal_id) {
		this.journal_id = journal_id;
	}
	public Set<Article> getArticles() {
		return articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	
	
}
