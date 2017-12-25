package cn.njasm.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cn.njasm.dao.UserDAO;
import cn.njasm.entity.User;
import cn.njasm.util.JDBCUtil;

public class UserDAOImpl implements UserDAO {
	private  final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
	private  final String user = "root";
	private  final String pass = "root";
	@Override
	public List<User> login(String name, String pass) throws Exception{
		Connection conn = JDBCUtil.getConn(url, user, this.pass);
		String sql = "select * from t_user where u_name=? and u_pass=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		List<User> users = new ArrayList<User>();
		while(rs.next()){
			User u = new User();
			u.setU_id(rs.getInt(1));
			u.setU_name(rs.getString(2));
			u.setU_pass(rs.getString(3));
			users.add(u);
		}
		JDBCUtil.close(ps, rs, conn);
		return users;
	}

	@Override
	public int register(User user)throws Exception {
		Connection conn = JDBCUtil.getConn(url, this.user, pass);
		String sql = "insert into t_user(u_name,u_pass) values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getU_name());
		ps.setString(2, user.getU_pass());
		int i = ps.executeUpdate();
		ResultSet rs = null;
		JDBCUtil.close(ps, rs, conn);
		return i;
	}

	@Override
	public List<User> checkName(String name)throws Exception {
		Connection conn = JDBCUtil.getConn(url, user, this.pass);
		String sql = "select * from t_user where u_name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		List<User> users = new ArrayList<User>();
		while(rs.next()){
			User u = new User();
			u.setU_id(rs.getInt(1));
			u.setU_name(rs.getString(2));
			u.setU_pass(rs.getString(3));
			users.add(u);
		}
		JDBCUtil.close(ps, rs, conn);
		return users;
	}

}
