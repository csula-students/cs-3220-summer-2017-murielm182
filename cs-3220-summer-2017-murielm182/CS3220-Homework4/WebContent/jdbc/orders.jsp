<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="Header.tld" prefix="tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/app.css' />">
</head>
<body>
	<header> <section class="container"> <tag:Header />
	</section> </header>
	<main>

	<h2>Your Orders</h2>
	<table>
		<thead>
			<th>Order Information</th>
			<th>Customer NAme</th>
			<th>Status</th>
		</thead>
		<tbody>

			<c:forEach items="${orders}" var="orders">
				<tr>
					<td>${orders.getCustomerName()}<br>
						${orders.getOrderTime()}
					</td>
					<table>

						<c:forEach items="${orders.getFoodItems()}" var="item">
							<tr>


								<td>${item.getName()}</td>
							</tr>
						</c:forEach>
					</table>
					</td>
					<td>${orders.getStatus()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br>
	<br>
	<a href="<c:url value='/menu' />" class="button">Back to Menu</a> <br>
	<a href="<c:url value='/shoppingcart' />" class="button">Back to
		Cart</a> <br><br>
</main>
	<footer>
	<h6>@ Copyright Jacob,Muriel inc. All rights reserved.</h6>
	</footer>

</body>
</html>