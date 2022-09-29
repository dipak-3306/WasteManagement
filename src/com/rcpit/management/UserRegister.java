package com.rcpit.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String occupation = request.getParameter("occupation");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		
		try
		{
			Connection obj = ConnectDb.connect();
			PreparedStatement ps1 = obj.prepareStatement("insert into user values(?,?,?,?,?,?)");
			ps1.setString(1, name);
			ps1.setString(2, address);
			ps1.setString(3, contact);
			ps1.setString(4, occupation);
			ps1.setString(5, email);
			ps1.setString(6, password);
		
			
			
			int i  = ps1.executeUpdate();
			
			if(i > 0)
			{
				response.sendRedirect("UserLogin.html");
			}
			else
			{
				response.sendRedirect("404.html");
			}
				
				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
