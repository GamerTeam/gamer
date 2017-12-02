package cn.gt.service.user;

import cn.gt.pojo.User;

public interface UserService {
	
	//判断账号是否可用
	User userNameExist(String userName);

	//添加用户
	int addUser(User user);
	//登录
	User selectUser(User user);
	//获取用户信息
	User selectUserInfo(int uId);
	
	int findId(String userName);

	boolean uploadInfo(User user);

	boolean upload(User user);


}

