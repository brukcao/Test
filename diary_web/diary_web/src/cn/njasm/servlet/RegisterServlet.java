package cn.njasm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.njasm.service.UserService;
import cn.njasm.service.factory.*;
import cn.njasm.entity.User;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setContentType("text/json;charset=utf-8");
		String name = request.getParameter("username");
		String pass = request.getParameter("pass");
		JSONObject jo = new JSONObject();
		UserService us = UserServiceFactory.getInstance();
		User user = new User();
		user.setU_name(name);
		user.setU_pass(pass);
		boolean flag = true;
		try {
			flag = us.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){
			jo.put("isSuccess", "success");
		}else{
			jo.put("isSuccess", "error");
		}
		
		PrintWriter out = response.getWriter();
		out.write(jo.toString());
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
