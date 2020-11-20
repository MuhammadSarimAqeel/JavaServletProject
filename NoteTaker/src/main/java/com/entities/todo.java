package com.entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class todo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	private String title;
	@Column(length= 2000)
	private String content;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public todo(int id, String title, String content, Date date) {
		super();
		this.id =id;
		this.title = title;
		this.content = content;
		this.date = date;
	}
	
	public todo(String title, String content, Date date) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
	}
	public todo() {
		super();
	}
	
	
	
}
