<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="Header.tld" prefix= "tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Food</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/app.css' />">
</head>
<body>

	<header>
		<section class="container">
			
			<tag:Header/>
		</section>

	</header>
<main>
		<section class="main">
			<h2 class="h2">Edit Food</h1>	
			
<form method="post">
Name: <input type="text" name="name" value="${toEdit.getName() }"><br>
Image URL: <input type="text" name="imageurl" value="${toEdit.getImageURL() }"><br>
Description: <input type="text" name="desc" value="${toEdit.getDescription()}"><br>
Price: <input type="number" step="0.01" name="price" value="${toEdit.getPrice() }"><br>

<input type="submit" value="Done">

</form>

		</section>

	</main>



<footer class="footer"><p>copyright Jacob,Muriel</p></footer>

</body>
</html>