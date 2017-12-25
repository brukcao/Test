package cn.njasm.dao.factory;

import cn.njasm.dao.DiaryDAO;
import cn.njasm.dao.impl.DiaryDAOImpl;

public class DiaryDAOFactory {
		public static DiaryDAO getInstance(){
			return new DiaryDAOImpl();
		}
}
