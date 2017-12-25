package cn.njasm.service.factory;

import cn.njasm.service.DiaryService;
import cn.njasm.service.UserService;
import cn.njasm.service.impl.DiaryServiceImpl;
import cn.njasm.service.impl.UserServiceImpl;

public class DiaryServiceFactory {
		public static DiaryService getInstance(){
			return new DiaryServiceImpl();
		}
}
