package com.mybatis.sqlsession;

import com.mybatis.config.Configuration;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

	// 等待注入
	private Configuration configuration;
	
	public DefaultSqlSessionFactory(Configuration configuration) {
		super();
		this.configuration = configuration;
	}

	@Override
	public SqlSession openSqlSession() {
		return new DefaultSqlSession(configuration);
	}

}
