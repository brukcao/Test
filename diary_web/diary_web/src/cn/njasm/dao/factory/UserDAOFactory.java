package cn.njasm.dao.factory;

import cn.njasm.dao.UserDAO;
import cn.njasm.dao.impl.UserDAOImpl;

public class UserDAOFactory {
			public static UserDAO getInstance(){
				return new UserDAOImpl();
			}
}
