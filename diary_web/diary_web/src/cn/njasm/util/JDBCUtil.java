package cn.njasm.util;
/**װ
 * @author majian
 *
 */
import java.sql.*;
public class JDBCUtil {

	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConn(String url,String user,String pass) 
														throws Exception{
		return DriverManager.getConnection(url,user,pass);
	}
	
	public static void close(PreparedStatement ps,ResultSet rs,Connection conn) throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
	
}
