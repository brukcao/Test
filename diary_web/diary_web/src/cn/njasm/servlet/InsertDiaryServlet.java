package cn.njasm.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.njasm.entity.Diary;
import cn.njasm.entity.User;
import cn.njasm.service.DiaryService;
import cn.njasm.service.factory.DiaryServiceFactory;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class EditDiaryServlet
 */
@WebServlet("/insertDiaryServlet")
public class InsertDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DiaryService ds = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setContentType("text/json;charset=utf-8");
		String d_name = request.getParameter("d_name");
		String d_content = request.getParameter("d_content");
		String d_dt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()); 
		int d_pri = Integer.parseInt(request.getParameter("d_pri"));
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		int u_id = u.getU_id();
		 ds = DiaryServiceFactory.getInstance();
		 Diary d = new Diary();
		 d.setD_dt(d_dt);
		 d.setD_content(d_content);
		 d.setD_name(d_name);
		 d.setD_pri(d_pri);
		 d.setU_id(u_id);
		 boolean  flag = true;
		 try {
			flag = ds.insertDiary(d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 JSONObject jo = new JSONObject();
		 if(flag == true){
			 System.out.println("写文章成功");
			 jo.put("isSuccess", "success");
		 }else{
			 jo.put("isSuccess", "error");
		 }
			response.getWriter().write(jo.toString());
			response.getWriter().flush();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
