package mybatis.demo.phase01.dao;


import mybatis.demo.phase01.entity.UserEntity;

public interface UserDao {

	UserEntity findUserById(int id);
}
