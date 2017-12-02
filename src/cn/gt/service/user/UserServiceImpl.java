package cn.gt.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gt.dao.user.UserDao;
import cn.gt.pojo.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	//登录
	public User selectUser(User user){
		User users = userDao.selectUser(user);
		return users;
		
	}

	//获取用户信息
	@Override
	public User selectUserInfo(int uId) {
		// TODO Auto-generated method stub
		User user = userDao.selectUserInfo(uId);
		return user;
	}
	
	//判断账号是否可用
	@Override
	public User userNameExist(String userName) {
		// TODO Auto-generated method stub
		User user = userDao.userNameExist(userName);
		return user;
	}

	//添加用户
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		int i = userDao.addUser(user);
		return i;
	}

	//profile.jsp中更换图片前验证是否登录状态
	@Override
	public int findId(String userName) {
		// TODO Auto-generated method stub
		int uId = userDao.findId(userName);
		return uId;
	}

	//profile.jsp更新用户资料
	@Override
	public boolean uploadInfo(User user) {
		// TODO Auto-generated method stub
		int i = userDao.uploadInfo(user);
		boolean flag = false;
		if(i == 1){
			flag = true;
		}
		return flag;
	}

	//profile.jsp更新用户头像
	@Override
	public boolean upload(User user) {
		// TODO Auto-generated method stub
		int i = userDao.upload(user);
		boolean flag = false;
		if(i == 1){
			flag = true;
		}
		return flag;
	}


}
