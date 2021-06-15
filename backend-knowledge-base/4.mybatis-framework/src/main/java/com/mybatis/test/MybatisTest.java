//package com.mybatis.test;//package com.kkb.mybatis.test;
//
//import java.io.InputStream;
//
//import com.mybatis.config.Configuration;
//import com.mybatis.po.User;
//import com.mybatis.sqlsession.SqlSession;
//import com.mybatis.sqlsession.SqlSessionFactory;
//import com.mybatis.sqlsession.SqlSessionFactoryBuilder;
//import com.mybatis.utils.Resources;
//import org.junit.Test;
//
//
//
//public class MybatisTest {
//
//	@Test
//	public void test() throws Exception {
//		// 指定全局配置文件的类路径
//		String resource = "SqlMapConfig.xml";
//		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
//		// InputStream inputStream = Resources.getResourceAsStream(resource);
//
//		XmlConfigBuilder builder = new XmlConfigBuilder(inputStream);
//		Configuration configuration = builder.parse();
//		System.out.println(configuration);
//	}
//
//	@Test
//	public void test1() throws Exception {
//		// 指定全局配置文件的类路径
//		String resource = "SqlMapConfig.xml";
//		InputStream inputStream = Resources.getResourceAsStream(resource);
//
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//		SqlSession sqlSession = sqlSessionFactory.openSqlSession();
//
//		User user = sqlSession.selectOne("findUserById", 1);
//
//		System.out.println(user);
//	}
//}
