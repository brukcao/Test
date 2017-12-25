package cn.njasm.dao;

import java.util.List;

import cn.njasm.entity.User;

public interface UserDAO {
	//登录
	public List<User> login(String name,String pass) throws Exception;
	//注册
	public int register(User user)throws Exception;
	public List<User> checkName(String name)throws Exception;
}
