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
 * Servlet implementation class userLogin
 */
@WebServlet("/userLogin")
public class userLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userLogin() {
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
		User user=gson.fromJson(json, User.class);
		
		BaseDAO dao=new BaseDAO();
		
		//String sql="insert into T_users(email,password) values(?,?)";
		String sql="select * from T_users where email=? and password=?";
		Object[]parmas=new Object[] {user.getEmail(),user.getPassword() };
		ResultSet rs= dao.select(sql, parmas);
		List<User> list= new ArrayList<User>();		
		try {
			if(rs.next()) {
				
				System.out.println("ok");				
//				User userLog= new User();
//				userLog.setId(rs.getInt("id"));
//				userLog.setName(rs.getString("name"));
//				userLog.setEmail(rs.getString("email"));
//				userLog.setPhone(rs.getString("phone"));
//				userLog.setGender(rs.getString("gender"));
//				userLog.setImage(rs.getString("image")); 
////				news.setImage("");
//			 list.add(userLog);
			// response.getWriter().append("1");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
//		System.out.println(list.get(0).getEmail());
//		Gson gsonNew= new Gson();
//		String jsonNew= gsonNew.toJson(list);
//		response.getWriter().append(jsonNew);
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
