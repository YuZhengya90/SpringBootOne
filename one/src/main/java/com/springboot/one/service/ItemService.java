package com.springboot.one.service;


import java.util.List;
import com.springboot.one.pojo.Item;

public interface ItemService{
	
	public Item getItem(int id);
	
	public List<Item> getAll();
	
	public boolean updateItem(Item item);


}