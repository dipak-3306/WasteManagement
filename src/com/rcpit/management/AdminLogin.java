package com.rcpit.management;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rcpit.management.ConnectDb;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminLogin() {
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
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		try
		{
			Connection obj = ConnectDb.connect();
			PreparedStatement ps1 = obj.prepareStatement("Select * from admin where email=? and pwd=?");
			ps1.setString(1, email);
			ps1.setString(2, pwd);
			ResultSet rs = ps1.executeQuery();
			if(rs.next())
			{
				response.sendRedirect("dashboard.html");
			}
			else
			{
				response.sendRedirect("index.html");
			
			}
				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}
