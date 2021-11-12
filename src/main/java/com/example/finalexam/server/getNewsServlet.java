package com.example.finalexam.server;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.finalexam.basic.BaseDAO; 
import com.example.finalexam.entities.News;
import com.google.gson.Gson;
 

/**
 * Servlet implementation class moviesServlet
 */
@WebServlet("/getNewsServlet")
public class getNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	String sql="select * from T_News order by id desc";
		
		BaseDAO dao= new BaseDAO();
		ResultSet rs= dao.select(sql);
			List<News> list= new ArrayList<News>();		
		try {
			while(rs.next()) {
				News news= new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setOverview(rs.getString("overview"));
				news.setCreator(rs.getString("creator"));
				news.setDate_created(rs.getString("created_date"));
				news.setImage(rs.getString("image"));
//				news.setImage("");
				list.add(news);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println(list.size());
		System.out.println(list.get(0).getTitle());
		Gson gson= new Gson();
		String json= gson.toJson(list);
		response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
