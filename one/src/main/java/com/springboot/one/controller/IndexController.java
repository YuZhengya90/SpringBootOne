package com.springboot.one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.one.pojo.Item;
import com.springboot.one.service.ItemService;

@RestController
public class IndexController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/getItem")
	public String getItem(int id) {
		
		return itemService.getItem(id).toString();
	}
	
	@GetMapping("/getAll")
	public String getAll() {
		StringBuilder sb = new StringBuilder();
		List<Item> itemList = itemService.getAll();
		for (Item item : itemList) {
			sb.append(item.toString());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	@GetMapping("/updateItem")
	public String updateItem(int id, Integer category) {
		Item item = itemService.getItem(id);
		item.setCategory(category);
		boolean result = itemService.updateItem(item);
		return result ? "Success" : "Failed";
	}
}