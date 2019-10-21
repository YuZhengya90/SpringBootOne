package com.springboot.one.pojo;

import org.springframework.stereotype.Component;

@Component
public class Item {
	private int id;
	private String name;
	private String link;
	private int category;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLink() {
		return link;
	}
	
	public int getCategory() {
		return category;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public void setCategory(int category) {
		this.category = category;
	}
	
	public String toString() {
		return id + name + link + category;
	}
}
