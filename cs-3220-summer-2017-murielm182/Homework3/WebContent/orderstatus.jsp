<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="Header.tld" prefix= "tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Status</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/app.css' />">
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
                <th>ID</th>
                    <th>Name</th>
                    <th>Image</th>
                    <th>Price</th>
                    <th>Status</th>
                </thead>
                
                <tbody>
                    <c:forEach items="${orderEntries.getFoodList()}" var="item">
                        <tr>
                        <td>${item.getFoodID() }
                            <td>${item.getFoodName()}</td>
                             <td><img src="<c:url value='${item.getFoodImageURL()}'/>" height="100" width="100"></td>
                            <td>${item.getFoodPrice()}</td>
                            <td><a href="<c:url value='/deletefromcart?id=${item.getFoodID()}' />" class="button">Delete</a>
                         
                            
                                
                                 </tr>
                  </c:forEach>
                       
                   
                </tbody>
            </table>
            <br>
            <br>
            <a href="<c:url value='/menu.jsp' />" class="button">View Menu</a>
            <br>
            <br>
            <a href="<c:url value='/admin/foods/new' />" class="button">Add new Food</a>&nbsp<a href="<c:url value='../admin/orders' />" class="button">View Current Orders</a>
            
            
            
            



	 </main>
	
	
	
	

</body>
</html>