<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="Header.tld" prefix= "tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value='/app.css' />">
<title>Shopping Cart</title>
</head>
<body>
	<header>
		<section class="container">
			
			<tag:Header/>
			
		</section>

	</header>
	<main> 
	<h1 class="h2">Shopping Cart</h1>
	<table class="tabel">
                <thead>
                    <th>Item</th>
                    <th>Image</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Options</th>
                </thead>
                
                <tbody>
                    <c:forEach items="${foodCart}" var="item">
                        <tr>
                            <td>${item.getName()}</td>
                            <td><img src="<c:url value='${item.getImageURL()}'/>" height="100" width="100"></td>
                           <td>${item.getDescription()}</td>
                            <td>${item.getPrice()}</td>
                            <td><a href="<c:url value='../admin/foods/delete?id=${item.getID()}' />" class="button">Remove</a>
                         
                            
                                
                                 </tr>
                  </c:forEach>
                       
                   
                </tbody>
            </table>
             <br>
            <br>
            <a href="<c:url value='/menu' />" class="button">View Menu</a>
            <br>
            <br>
            
            
            



	 </main>
	<footer>
		<h6> @ Copyright Jacob,Muriel inc. All rights reserved.
		</h6>
	</footer>

</body>
</html>