package cn.njasm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.njasm.dao.DiaryDAO;
import cn.njasm.entity.Diary;
import cn.njasm.entity.User;
import cn.njasm.util.JDBCUtil;

public class DiaryDAOImpl implements DiaryDAO {
	private  final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
	private  final String user = "root";
	private  final String pass = "root";
	@Override
	public List<Diary> checkAllMySelfDiary(int u_id) throws Exception {
		Connection conn = JDBCUtil.getConn(url, user, this.pass);
		String sql = "select * from t_diary where u_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, u_id);
		ResultSet rs = ps.executeQuery();
		List<Diary> diarys = new ArrayList<Diary>();
		while(rs.next()){
			Diary d = new Diary();
			d.setD_id(rs.getInt(1));
			d.setD_name(rs.getString(2));
			d.setD_content(rs.getString(3));
			d.setD_dt(rs.getString(4));
			d.setD_pri(rs.getInt(5));
			d.setU_id(rs.getInt(6));
			diarys.add(d);
		}
		JDBCUtil.close(ps, rs, conn);
		return diarys;
	}

	@Override
	public List<Diary> checkAllOtherDiary(int u_id) throws Exception {
		Connection conn = JDBCUtil.getConn(url, user, this.pass);
		String sql = "select * from t_diary where u_id!=? and d_pri=0";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, u_id);
		ResultSet rs = ps.executeQuery();
		List<Diary> diarys = new ArrayList<Diary>();
		while(rs.next()){
			Diary d = new Diary();
			d.setD_id(rs.getInt(1));
			d.setD_name(rs.getString(2));
			d.setD_content(rs.getString(3));
			d.setD_dt(rs.getString(4));
			d.setD_pri(rs.getInt(5));
			d.setU_id(rs.getInt(6));
			diarys.add(d);
		}
		JDBCUtil.close(ps, rs, conn);
		return diarys;
	}

	@Override
	public int editDiary(Diary d) throws Exception {
		Connection conn = JDBCUtil.getConn(url, user, this.pass);
		String sql = "update t_diary set d_name=?,d_content=?,d_dt=?,d_pri=? where d_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, d.getD_name());
		ps.setString(2, d.getD_content());
		ps.setString(3, d.getD_dt());
		ps.setInt(4, d.getD_pri());
		ps.setInt(5, d.getD_id());
		int i  = ps.executeUpdate();
		ResultSet rs = null;
		JDBCUtil.close(ps, rs, conn);
		return i;
	}

	@Override
	public int delDiary(int d_id) throws Exception {
		Connection conn = JDBCUtil.getConn(url, user, this.pass);
		String sql = "delete from t_diary where d_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,d_id);
		int i  = ps.executeUpdate();
		ResultSet rs = null;
		JDBCUtil.close(ps, rs, conn);
		return i;
	}

	@Override
	public int insertDiary(Diary d) throws Exception {
		Connection conn = JDBCUtil.getConn(url, user, this.pass);
		String sql = "insert into t_diary(d_name,d_content,d_dt,d_pri,u_id) values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, d.getD_name());
		ps.setString(2, d.getD_content());
		ps.setString(3, d.getD_dt());
		ps.setInt(4, d.getD_pri());
		ps.setInt(5, d.getU_id());
		int i  = ps.executeUpdate();
		ResultSet rs = null;
		JDBCUtil.close(ps, rs, conn);
		return i;
	}

	@Override
	public List<Diary> checkDiary(int d_id) throws Exception {
		Connection conn = JDBCUtil.getConn(url, user, this.pass);
		String sql = "select * from t_diary where d_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, d_id);
		ResultSet rs = ps.executeQuery();
		List<Diary> diarys = new ArrayList<Diary>();
		while(rs.next()){
			Diary d = new Diary();
			d.setD_id(rs.getInt(1));
			d.setD_name(rs.getString(2));
			d.setD_content(rs.getString(3));
			d.setD_dt(rs.getString(4));
			d.setD_pri(rs.getInt(5));
			d.setU_id(rs.getInt(6));
			diarys.add(d);
		}
		JDBCUtil.close(ps, rs, conn);
		return diarys;
	}

}
