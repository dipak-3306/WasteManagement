<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="com.rcpit.management.ConnectDb" %>
<%@page import="com.rcpit.management.GetterandSetter" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Css -->
    <link rel="stylesheet" href="./dist/styles.css">
    <link rel="stylesheet" href="./dist/all.css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,600,600i,700,700i" rel="stylesheet">
    <title>View Raised Request </title>
</head>

<body>
<!--Container -->
<div class="mx-auto bg-grey-lightest">
    <!--Screen-->
    <div class="min-h-screen flex flex-col">
        <!--Header Section Starts Here-->
        <header class="bg-nav">
            <div class="flex justify-between">
                <div class="p-1 mx-3 inline-flex items-center">
                    <i class="fas fa-bars pr-2 text-white" onclick="sidebarToggle()"></i>
                    <h1 class="text-white p-2">Application</h1>
                </div>
               
            </div>
        </header>
        <!--/Header-->

        <div class="flex flex-1">
            <!--Sidebar-->
            <aside id="sidebar" class="bg-side-nav w-1/2 md:w-1/6 lg:w-1/6 border-r border-side-nav hidden md:block lg:block">
                <div class="flex">

                </div>
                <ul class="list-reset flex flex-col">
                    <li class=" w-full h-full py-3 px-2 border-b border-light-border ">
                        <a href="index.html"
                           class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                            <i class="fas fa-tachometer-alt float-left mx-2"></i>
                            
                            <span><i class="fas fa-angle-right float-right"></i></span>
                        </a>
                    </li>
                    <li class="w-full h-full py-3 px-2 border-b border-light-border">
                        <a href="Raised.jsp"
                           class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                            <i class="fab fa-wpforms float-left mx-2"></i>
                            Raised CND Request
                            <span><i class="fa fa-angle-right float-right"></i></span>
                        </a>
                    </li>
                    <li class="w-full h-full py-3 px-2 border-b border-light-border">
                        <a href="ViewRaise.jsp"
                           class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                            <i class="fas fa-grip-horizontal float-left mx-2"></i>
                            View CND Request
                            <span><i class="fa fa-angle-right float-right"></i></span>
                        </a>
                    </li>
                    <a href="userdashboard.html" class="hvr-shutter-in-horizontal">Go To Home</a>
                    
                    
                                  </ul>

            </aside>
            <!--/Sidebar-->
            <!--Main-->
            <main class="bg-white-500 flex-1 p-3 overflow-hidden">

                <div class="flex flex-col">
                    <!-- Card Sextion Starts Here -->
                    <div class="flex flex-1  flex-col md:flex-row lg:flex-row mx-2">
                        <!--Horizontal form-->
                        <div class="mb-2 border-solid border-grey-light rounded border shadow-sm w-full md:w-1/2 lg:w-1/2">
                            
                                   
                            </div>
                        </div>
                        <!--/Horizontal form-->

                       
                    <!-- /Cards Section Ends Here -->

                    <!--Grid Form-->

                    <div class="flex flex-1  flex-col md:flex-row lg:flex-row mx-2">
                        <div class="mb-2 border-solid border-gray-300 rounded border shadow-sm w-full">
                            <div class="bg-gray-200 px-2 py-3 border-solid border-gray-200 border-b">
                                View CND Request
                            </div>
                            <div class="p-3">
                                <table class="table-responsive w-full rounded">
                                    <thead>
                                      <tr>
                                        <th class="border w-1/4 px-4 py-2">Address</th>
                                        <th class="border w-1/6 px-4 py-2">Title</th>
                                        <th class="border w-1/6 px-4 py-2">Description</th>
                                         <th class="border w-1/6 px-4 py-2">Status</th>
                                        <th class="border w-1/6 px-4 py-2">Image</th>
                                       </tr>
                                    </thead>
                                    
                                    
<%
    Connection obj = ConnectDb.connect();
	try
	{
		
		PreparedStatement ps1 = obj.prepareStatement("select * from cnd where email = ?");
		ps1.setString(1, GetterandSetter.getMail());
		ResultSet rs1 = ps1.executeQuery();
		while(rs1.next())
		{
%>
		 <tbody>
                   
		<tr>
			<td class="border px-4 py-2"><%=rs1.getString("address")%></td>
			<td class="border px-4 py-2"><%=rs1.getString("title")%></td>
			<td class="border px-4 py-2"><%=rs1.getString("description")%></td>
		    <td class="border px-4 py-2"><%=rs1.getString("status")%></td>
		    <td class="border px-4 py-2"><%=rs1.getBlob("image") %></td>
		   
		
		</tr>
		</tbody>
		
<%
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
                                    
                  
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--/Grid Form-->
                </div>
            </main>
            <!--/Main-->
        </div>
        <!--Footer-->
       
        <!--/footer-->

    </div>

</div>

<script src="./main.js"></script>

</body>

</html>