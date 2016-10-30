package com.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Set;

@XmlType(name = "user")
public class User {

	@XmlElement(name = "userid")
	private Integer userid;
    @XmlElement(name = "username")
	private String username;
    @XmlElement(name = "password")
	private String password;
    @XmlElement(name = "email")
	private String email;
    @XmlElement(name = "note")
	private String note;
    @XmlElement(name = "admin")
	private Boolean admin;
    @XmlElementWrapper(name = "paragraph")
    //@XmlElement(name = "paragraph")
	private Set<Paragraph> paragraphs;
	
	public User(){}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Set<Paragraph> getParagraphs() {
		return paragraphs;
	}

	public void setParagraphs(Set<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}

}
