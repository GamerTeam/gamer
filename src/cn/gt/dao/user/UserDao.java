package cn.gt.dao.user;

import org.apache.ibatis.annotations.Param;

import cn.gt.pojo.User;

public interface UserDao {
	
	//判断账号是否可用
	User userNameExist(String userName);

	//添加用户
	int addUser(User user);

	//登录
	User selectUser(User user);
	
	//获取用户信息
	User selectUserInfo(int uId);

	int findId(String userName);

	int uploadInfo(User user);

	int upload(User user);



}
