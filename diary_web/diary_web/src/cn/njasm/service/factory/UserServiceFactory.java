package cn.njasm.service.factory;

import cn.njasm.service.UserService;
import cn.njasm.service.impl.UserServiceImpl;

public class UserServiceFactory {
		public static UserService getInstance(){
			return new UserServiceImpl();
		}
}
