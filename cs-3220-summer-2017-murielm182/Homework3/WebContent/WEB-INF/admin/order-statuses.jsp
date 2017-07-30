<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="Header.tld" prefix= "tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Statuses</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/app.css' />">
</head>
<body>
<header>
		<section class="container">
			
			<tag:Header/>
			
			
		</section>

	</header>
	<main> 
	<h1 class="h2">Current Order Statuses</h1>
	
	<table class="cart-table" border="1" bordercolor="#228B22" cellspacing="0" cellpadding="4">
                <thead>
                    <th>Date</th>
                    <th>Order Number</th>
                    <th>Customer Name</th>
                    <th>Food Item</th>
                    <th>Status</th>
                </thead>
                
                <tbody>
                    <c:forEach items="${orderEntries}" var="record">
                    <c:set var="alphabet" value="${record.getFoodList() }"/>
                        <tr>
                        <td>${record.getDate()}</td>
                            <td>${record.getID()}</td>
                           
                            <td>${record.getCustomerName()}</td>
                            <td>alphabet.getFoodName()  </td>
                            <td><select>
				<option value="pending">IN PROGRESS</option>
				<option value="in-queue">IN QUEUE</option>
				<option value="completed">COMPLETE</option>
			</select>
                           </td>
                                 </tr>
                  </c:forEach>
                       
                   
                </tbody>
            </table>
            <br><a href="<c:url value='../admin/foods/editorderstatus' />" class="button">Update Changes</a>



	 </main>
	<footer>
		<h6> @ Copyright Jacob,Muriel inc. All rights reserved.
		</h6>
	</footer>

</body>
</html>