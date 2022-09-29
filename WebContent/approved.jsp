<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="com.rcpit.management.ConnectDb" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approved Section</title>
</head>
<body>
<% 
		int id =Integer.parseInt(request.getParameter("id"));
		
		try
		{
			Connection obj = ConnectDb.connect();
			PreparedStatement ps1 = obj.prepareStatement("update cnd set status=? where id=?");
			ps1.setString(1,"approved");
			ps1.setInt(2,id);
			
			int rs = ps1.executeUpdate();
			if(rs>0)
			{
				response.sendRedirect("AdminView.jsp");
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
%>

</body>
</html>