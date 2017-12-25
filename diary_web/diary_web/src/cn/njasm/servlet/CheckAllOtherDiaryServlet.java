package cn.njasm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.njasm.entity.Diary;
import cn.njasm.service.DiaryService;
import cn.njasm.service.factory.DiaryServiceFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class CheckAllMySelfDiaryServlet
 */
@WebServlet(name = "checkAllOtherDiaryServlet", urlPatterns = { "/checkAllOtherDiaryServlet" })
public class CheckAllOtherDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    DiaryService ds = null;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setContentType("text/json;charset=utf-8");
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		 ds = DiaryServiceFactory.getInstance();
		 List<Diary> ll = null;
		 try {
			ll  = ds.checkAllOtherDiary(u_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 JSONObject jo = new JSONObject();
		 if(ll.size()>0){
		 jo.put("isSuccess", "success");
		 jo.put("diarys", ll);
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
