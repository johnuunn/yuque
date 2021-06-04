package mybatis.demo.phase02.mapper;


import mybatis.demo.phase02.po.User;

public interface UserMapper {
	User findUserById(int id);
}
