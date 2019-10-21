package com.springboot.one.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.springboot.one.pojo.Item;

@Mapper
public interface ItemMapper {
	
	@Select ("SELECT * FROM OITM WHERE id=#{id}")
	public Item getItem(int id);
	
	@Select ("SELECT * FROM OITM")
	@Results (id="id", value= {
			@Result(column="name", property="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
			@Result(column="category", property="category", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
			@Result(column="link", property="link", javaType=String.class, jdbcType=JdbcType.VARCHAR)
	})
	public List<Item> getAll();
	
	@Update ("UPDATE OITM SET name=#{name}, category=#{category}, link=#{link} WHERE id = #{id} ")
	public void updateItem(Item item);
}