package cn.njasm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.njasm.entity.User;
import cn.njasm.service.UserService;
import cn.njasm.service.factory.UserServiceFactory;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setContentType("text/json;charset=utf-8");
		String name = request.getParameter("username");
		String pass = request.getParameter("pass");
		JSONObject jo = new JSONObject();
		UserService us = UserServiceFactory.getInstance();
		User u = null;
		try {
			u = us.login(name, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(u != null ){
			jo.put("isSuccess", "success");
			jo.put("resData",u );
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
		}else{
			jo.put("isSuccess", "error");
			jo.put("resData", null);
		}
		
		PrintWriter out = response.getWriter();
		out.write(jo.toString());
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
