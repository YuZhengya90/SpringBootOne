package com.springboot.one.service;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;


import com.springboot.one.dao.ItemMapper;
import com.springboot.one.pojo.Item;
import com.springboot.one.util.AppSqlSession;

@Component
public class ItemServiceImpl implements ItemService {

	
	@Override
	public Item getItem(int id) {
		
		Item item = null;
		try {
			ItemMapper itemMapper = AppSqlSession.getSession().getMapper(ItemMapper.class);
			item = itemMapper.getItem(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return item;
	}

	@Override
	public List<Item> getAll() {
		
		List<Item> itemList = null;
		try {
			ItemMapper itemMapper = AppSqlSession.getSession().getMapper(ItemMapper.class);
			itemList = itemMapper.getAll();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return itemList;
	}

	@Override
	public boolean updateItem(Item item) {

		try {
			ItemMapper itemMapper = AppSqlSession.getSession().getMapper(ItemMapper.class);
			itemMapper.updateItem(item);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}