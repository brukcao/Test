package cn.njasm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.njasm.entity.User;
import net.sf.json.JSONObject;

/**
 * 用来判断当没有登录的时候就通过URL访问其他页面的时候禁止被访问的操作
 */
@WebServlet("/checkSessionServlet")
public class CheckSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession session  = request.getSession();
				User u = (User)session.getAttribute("user");
				JSONObject jo = new JSONObject();
				if(u == null){
					jo.put("isSuccess", "error");
				}else{
					jo.put("isSuccess", "success");
					jo.put("user", u);
				}
				response.getWriter().write(jo.toString());
				response.getWriter().flush();
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
