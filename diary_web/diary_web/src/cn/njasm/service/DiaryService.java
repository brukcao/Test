package cn.njasm.service;

import java.util.List;

import cn.njasm.entity.Diary;

public interface DiaryService {
	   //查看自己所有的日志
		public List<Diary> checkAllMySelfDiary(int u_id) throws Exception;
		//查看其它人的日志
		public List<Diary> checkAllOtherDiary(int u_id) throws Exception;
		//修改自己的日志
		public boolean editDiary(Diary d) throws Exception;
		//删除自己的日志
		public boolean delDiary(int d_id) throws Exception;
		//写自己的日志
		public boolean insertDiary(Diary d) throws Exception;
		//查看自己的一篇日志
		public Diary checkDiary(int d_id) throws Exception;
}
