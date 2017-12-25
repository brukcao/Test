package cn.njasm.service.impl;

import java.util.List;

import cn.njasm.dao.DiaryDAO;
import cn.njasm.dao.factory.DiaryDAOFactory;
import cn.njasm.entity.Diary;
import cn.njasm.service.DiaryService;

public class DiaryServiceImpl implements DiaryService {
	DiaryDAO dd = null;
	@Override
	public List<Diary> checkAllMySelfDiary(int u_id) throws Exception {
		dd = DiaryDAOFactory.getInstance();
		List<Diary> ll = dd.checkAllMySelfDiary(u_id);
		return ll;
	}

	@Override
	public List<Diary> checkAllOtherDiary(int u_id) throws Exception {
		dd = DiaryDAOFactory.getInstance();
		return dd.checkAllOtherDiary(u_id);
	}

	@Override
	public boolean editDiary(Diary d) throws Exception {
		dd = DiaryDAOFactory.getInstance();
		int i = dd.editDiary(d);
		if(i>0){
			return true;
		}else return false;
	}

	@Override
	public boolean delDiary(int d_id) throws Exception {
		dd = DiaryDAOFactory.getInstance();
		int i = dd.delDiary(d_id);
		if(i>0){
			return true;
		}else return false;
	}

	@Override
	public boolean insertDiary(Diary d) throws Exception {
		dd = DiaryDAOFactory.getInstance();
		int i = dd.insertDiary(d);
		if(i>0){
			return true;
		}else return false;
	}

	@Override
	public Diary checkDiary(int d_id) throws Exception {
		dd = DiaryDAOFactory.getInstance();
		List<Diary> ll = dd.checkDiary(d_id);
		return ll.get(0);
	}

}
