package com.springboot.one.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AppSqlSession {
	
	private static SqlSessionFactory sqlSessionFactory = null;
	public static SqlSessionFactory getSessionFactory() throws IOException {
		if (null == sqlSessionFactory) {
			String resource = "mybatis/mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			sqlSessionFactory.getConfiguration().addMappers("com.springboot.one.dao");
		}
		return sqlSessionFactory;
	}
	
	public static SqlSession getSession() throws IOException {
		return AppSqlSession.getSessionFactory().openSession(true);
	}
};
