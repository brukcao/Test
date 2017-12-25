package cn.njasm.service.impl;

import java.util.List;

import cn.njasm.dao.UserDAO;
import cn.njasm.dao.factory.UserDAOFactory;
import cn.njasm.entity.User;
import cn.njasm.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userdao = null;
	@Override
	public User login(String name, String pass) throws Exception {
		userdao = UserDAOFactory.getInstance();
		List<User> users = userdao.login(name, pass);
		if(users.size()>0){
			return users.get(0);
		}else{
		return null;
		}
	}

	@Override
	public boolean register(User user) throws Exception {
		userdao = UserDAOFactory.getInstance();
		List<User> ll  = userdao.checkName(user.getU_name());
		if(ll.size()>0){
			return false;
		}else{
			int i = userdao.register(user);
			if(i>0){
		return true;
			}else return false;
		}
		}

	

}
