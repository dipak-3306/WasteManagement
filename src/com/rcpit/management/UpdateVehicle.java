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
public class UpdateVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVehicle() {
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
		String dname = request.getParameter("dname");
		String dcontact = request.getParameter("dcontact");
		String vnumber = request.getParameter("vnumber");
		
		
		
		try
		{
			Connection obj = ConnectDb.connect();
			PreparedStatement ps1 = obj.prepareStatement("update vehicle set dname=?,dcontact=? where vnumber=? ");
			ps1.setString(1, dname);
			ps1.setString(2, dcontact);
			ps1.setString(3, vnumber);
			
			
			
			int i  = ps1.executeUpdate();
			
			if(i > 0)
			{
				response.sendRedirect("dashboard.html");
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
