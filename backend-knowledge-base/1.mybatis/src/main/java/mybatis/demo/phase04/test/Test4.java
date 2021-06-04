package mybatis.demo.phase04.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mybatis.demo.phase04.mapper.UserMapper;
import mybatis.demo.phase04.po.User;
import mybatis.demo.phase04.po.UserExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


/**
 * 测试逆向工程代码和PageHelper分页插件案例
 * @date: 2021/6/4
 * @auther: liu
 */
public class Test4 {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws Exception {
		// 加载全局配置文件（同时把映射文件也加载了）
		String resource = "phase04/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// sqlsessionFactory需要通过sqlsessionFactoryBuilder读取全局配置文件信息之后
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void test() {
		// 创建UserMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		UserExample example = new UserExample();
		List<User> list = mapper.selectByExample(example);
		System.out.println(list);
	}
	@Test
	public void test2() {
		// 创建UserMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		//拦截器 注入实现分页，把sql 拼接到语句上
		//编写分页代码
		PageHelper.startPage(1, 2);
		
		UserExample example = new UserExample();
		// 此处返回的list实现类不再是ArrayList，而是PageHelper提供的Page对象
		List<User> list = mapper.selectByExample(example);
		System.out.println(list);
		//转为 page 对象
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		System.out.println(pageInfo);
	}

}
