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
import com.example.finalexam.entities.User;
import com.google.gson.Gson;

/**
 * Servlet implementation class getContactServlet
 */
@WebServlet("/getContactServlet")
public class getContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String sql="select * from t_users join  t_contact on t_users.email=t_contact.userB ";
			//" WHERE t_contact.userA like \"% ?%\";";
		
	BaseDAO dao= new BaseDAO();
	ResultSet rs= dao.select(sql);
	List<User> list= new ArrayList<User>();
			
	try {
		while(rs.next()) {
			User contact= new User();
			contact.setId(rs.getInt("id"));
			contact.setName(rs.getString("name"));
			contact.setPhone(rs.getString("phone"));
			contact.setGender(rs.getString("gender"));
			contact.setImage(rs.getString("image"));
			list.add(contact);
		}
	
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	System.out.println(list.size());
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
