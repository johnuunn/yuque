package mybatis.demo.phase01.dao;

import mybatis.demo.phase01.entity.UserEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 * 后面会通过反射和代理 实现 sqlSession查询
 * @date: 2021/6/4
 * @auther: liu
 */
public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;

	// 注入sqlSessionFactory
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public UserEntity findUserById(int id) {
		// sqlsessionFactory工厂类去创建sqlsession会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// sqlsession接口，开发人员使用它对数据库进行增删改查操作   test 来自xml namespace
		UserEntity user = sqlSession.selectOne("test.findUserById", id);
		return user;
	}

}
