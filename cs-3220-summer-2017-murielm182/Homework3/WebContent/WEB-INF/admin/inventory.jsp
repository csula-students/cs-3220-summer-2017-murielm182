<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="Header.tld" prefix= "tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tea House</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/app.css' />">
</head>
<body>
	<header>
		<section class="container">
			
			<tag:Header/>
			
		</section>

	</header>
	<main> 
	
	<table class="tabel">
                <thead>
                    <th>Item</th>
                    <th>Image</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Status</th>
                </thead>
                
                <tbody>
                    <c:forEach items="${inventory}" var="item">
                        <tr>
                            <td>${item.getFoodName()}</td>
                            
                            <td><img src="<c:url value='${item.getFoodImageURL()}'/>" height="100" width="100"></td>
                           <td>${item.getDescription()}</td>
                            <td>${item.getFoodPrice()}</td>
                            <td><a href="<c:url value='../admin/foods/delete?id=${item.getFoodID()}' />" class="button">Delete</a>
                         
                            
                                
                                 </tr>
                  </c:forEach>
                       
                   
                </tbody>
            </table>
            <br>
            <br>
            <a href="<c:url value='../menu.jsp' />" class="button">View Menu</a>
            <br>
            <br>
            <a href="<c:url value='../admin/foods/new' />" class="button">Add new Food</a>&nbsp<a href="<c:url value='/orders' />" class="button">View Current Orders</a>
            
            
            
            



	 </main>
	<footer>
		<h6> @ Copyright Jacob,Muriel inc. All rights reserved.
		</h6>
	</footer>

</body>
</html>