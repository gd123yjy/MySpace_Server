package com.bean;

import javax.xml.bind.annotation.*;

@XmlType(name = "paragraph")
public class Paragraph {

    @XmlElement(name = "paragraph_id")
	private Integer paragraph_id;
    @XmlElement(name = "sequence")
	private Integer sequence;
    @XmlElement(name = "content")
	private String content;
    @XmlElement(name = "score")
	private Double score;
    @XmlElement(name = "score_num")
	private Integer score_num;
	@XmlTransient
	private Chapter chapter;
    @XmlTransient
    private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getParagraph_id() {
		return paragraph_id;
	}
	public void setParagraph_id(Integer paragraph_id) {
		this.paragraph_id = paragraph_id;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getScore_num() {
		return score_num;
	}
	public void setScore_num(Integer score_num) {
		this.score_num = score_num;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	
	
}
