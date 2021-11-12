package com.example.finalexam.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.finalexam.basic.BaseDAO; 
import com.example.finalexam.entities.User;
import com.google.gson.Gson;

/**
 * Servlet implementation class updateUser
 */
@WebServlet("/updateUser")
public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUser() {
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
		User classMate=gson.fromJson(json, User.class);
		
		BaseDAO dao=new BaseDAO();
		
		String sql="UPDATE T_users SET name=?, phone=?, gender=?, image=? "
				+ " WHERE email = ?";
		 
		Object[]parmas=new Object[] {classMate.getName(),classMate.getPhone(),
				classMate.getGender(),classMate.getImage(),classMate.getEmail()};
		dao.update(sql, parmas);
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
