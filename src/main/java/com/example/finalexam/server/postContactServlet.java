package com.example.finalexam.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.finalexam.basic.BaseDAO;
import com.example.finalexam.entities.User;
import com.example.finalexam.entities.Contact;
import com.example.finalexam.entities.News;
import com.google.gson.Gson;

/**
 * Servlet implementation class postContactServlet
 */
@WebServlet("/postContactServlet")
public class postContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postContactServlet() {
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
		Contact contact=gson.fromJson(json, Contact.class);
		
		BaseDAO dao=new BaseDAO();
		
		String sql="insert into T_contact(userA, userB) values(?,?)";
		Object[]parmas=new Object[] {contact.getUserA(),contact.getUserB()};
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
