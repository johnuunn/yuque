package com.mybatis.test;

import com.mybatis.config.Configuration;
import com.mybatis.config.XMLConfigParser;
import com.mybatis.dao.UserDao;
import com.mybatis.dao.UserDaoImpl;
import com.mybatis.po.User;
import com.mybatis.sqlsession.SqlSessionFactory;
import com.mybatis.sqlsession.SqlSessionFactoryBuilder;
import com.mybatis.utils.DocumentUtils;
import com.mybatis.utils.Resources;
import org.dom4j.Document;
import org.junit.Test;

import java.io.InputStream;

public class UserDaoTest {

	/**
	 * 配置文件读取流程测试
	 * @throws Exception
	 */
	@Test
	public void testInitConfiguration() throws Exception {
		// 指定全局配置文件路径
		String resource = "SqlMapConfig.xml";
		// 获取指定路径的IO流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 获取Document对象
		Document document = DocumentUtils.readDocument(inputStream);
		// 解析Document获取Configuration对象
		XMLConfigParser configParser = new XMLConfigParser();

		// <configuration>
		Configuration configuration = configParser.parse(document.getRootElement());
		System.out.println(configuration);
	}

	/**
	 * JDBC 实现查询
	 */
	@Test
	public void testQueryUserById() {
		UserDao userDao = new UserDaoImpl();
		User param = new User();
		param.setId(1);
		User user = userDao.queryUserById(param);
		System.out.println(user);

	}

	/**
	 * 使用手写mybatis框架去实现的
	 */
	@Test
	public void testQueryUserById2() {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// SqlSessionFactory的创建可能有几种创建方式，但是我还是不想要知道SqlSessionFactory的构造细节
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User param = new User();
		param.setId(1);
		param.setSex("男");//解析参数出现错误
		User user = userDao.queryUserById2(param);
		System.out.println(user);
	}

}
