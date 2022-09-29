package com.rcpit.management;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class raisedCnd
 */
@WebServlet(name="Raised",urlPatterns=("/Raised"))
@MultipartConfig(maxFileSize = 16177216) // 1.5 mb
public class raisedCnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public raisedCnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    PrintWriter out;
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	int id=0;
		String address = request.getParameter("address");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String status ;
		response.setContentType("text/html;charset=UTF-8");
		out=response.getWriter();
		int result=0;
		Part part=request.getPart("image");
		String email = GetterandSetter.getMail();
		
		
		if(part!=null){
		try
		{
			Connection obj = ConnectDb.connect();
			PreparedStatement ps1 = obj.prepareStatement("insert into cnd values(?,?,?,?,?,?,?)");
			InputStream is = part.getInputStream();
			ps1.setString(1, address);
			ps1.setString(2, title);
			ps1.setString(3, description);
			ps1.setString(4, "disapprove");
			ps1.setInt(5,id);
			ps1.setBlob(6, is);
			ps1.setString(7,email);
		
			
			
			int i  = ps1.executeUpdate();
			
			if(i > 0)
			{
				response.sendRedirect("RaisedCnd.html");
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
}
	
}
