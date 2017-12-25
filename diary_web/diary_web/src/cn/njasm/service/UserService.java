package cn.njasm.service;

import java.util.List;

import cn.njasm.entity.User;

public interface UserService {
	public User login(String name,String pass) throws Exception;
	public boolean register(User user)throws Exception;
}
