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
public class AddVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicle() {
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
		String vnumber = request.getParameter("vnumber");
		String dname = request.getParameter("dname");
		String dcontact = request.getParameter("dcontact");
		
		
		
		try
		{
			Connection obj = ConnectDb.connect();
			PreparedStatement ps1 = obj.prepareStatement("insert into vehicle values(?,?,?)");
			ps1.setString(1, vnumber);
			ps1.setString(2, dname);
			ps1.setString(3, dcontact);
			
			
			
			int i  = ps1.executeUpdate();
			
			if(i > 0)
			{
				response.sendRedirect("addvehicle.html");
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
