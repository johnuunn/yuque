package com.mybatis.sqlsession;

import java.io.InputStream;
import java.io.Reader;

import org.dom4j.Document;

import com.mybatis.config.Configuration;
import com.mybatis.config.XMLConfigParser;
import com.mybatis.utils.DocumentUtils;

/**
 * 使用构建者模式对SqlSessionFactory进行创建
 * 
 * @author liu
 *
 */
public class SqlSessionFactoryBuilder {

	public SqlSessionFactory build(InputStream inputStream) {
		// 获取Configuration对象
		Document document = DocumentUtils.readDocument(inputStream);
		XMLConfigParser configParser = new XMLConfigParser();
		Configuration configuration = configParser.parse(document.getRootElement());
		return build(configuration);
	}

	public SqlSessionFactory build(Reader reader) {
		return null;
	}

	private SqlSessionFactory build(Configuration configuration) {
		return new DefaultSqlSessionFactory(configuration);
	}
}
