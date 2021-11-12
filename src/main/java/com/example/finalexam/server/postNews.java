package com.example.finalexam.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.finalexam.basic.BaseDAO; 
import com.example.finalexam.entities.News;
import com.google.gson.Gson;

/**
 * Servlet implementation class postNews
 */
@WebServlet("/postNews")
public class postNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String json=request.getParameter("json");
		System.out.println(json);
		Gson gson=new Gson();
		News news=gson.fromJson(json, News.class);
		
		BaseDAO dao=new BaseDAO();
		
		String sql="insert into t_news(title,overview,created_date,image, creator) values(?,?,NOW(),?,?)";
		Object[]parmas=new Object[] {news.getTitle(),news.getOverview(), news.getImage(), news.getCreator() };
		dao.insert(sql, parmas);
		System.out.println("SUCCESS");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
