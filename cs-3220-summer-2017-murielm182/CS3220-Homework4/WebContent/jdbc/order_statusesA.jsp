<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="Header.tld" prefix="tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admins Order Statuses</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/app.css' />">
</head>
<body>

<header> <section class="container"> <tag:Header />
	</section> </header>
	
	<main>
<h3> Manage Orders  </h3>
            
            <table>
                <thead>
                    <th>Order Information</th>
                    <th>Requests</th>
                    <th>Status</th>
                    <th></th>
                   
                </thead>
                <tbody>
                    <c:forEach items="${orders}" var="orders">
                        <tr>
                            <td>${orders.getCustomerName()}<br>
                                ${orders.getOrderTime()}
                            </td>
                            
                            <td>
                                <table class="center">
                                    <c:forEach items="${orders.Food()}" var="item">
                                        <tr>
                                            
                                            
                                            <td> ${item.getName()} </td>
                                        </tr>
                                    </c:forEach> 
                                </table>
                            </td>

                            <td>${orders.getstatus()}</td>
                            <td><a href="<c:url value='../editfood?id=${item.getID()}' />" class="button">Edit</a>|<a href="<c:url value='/deletefood?id=${item.getID()}' />" class="button">Delete</a>
                            
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>


</main> 

</body>
</html>