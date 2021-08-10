<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<label>Your Gold: <input type ="number" name = "goldCount" value = "${count}"></label>
	</div>
	<div>
		<form action ="/goldProcess" method = "POST">
				<h2>Farm </h2>
				<p>(earn 10-20 gold)</p>
				<input type = "hidden" name="location" value="farm">
				<button>Find Gold!</button>
		</form>
		
		<form action ="/goldProcess" method = "POST">
				<h2>Cave </h2>
				<p>(earn 5-10 gold)</p>
				<input type = "hidden" name = "location" value="cave">
				<button>Find Gold!</button>
		</form>
		
		<form action ="/goldProcess" method = "POST">
				<h2>House </h2>
				<p>(earn 2-5 gold)</p>
				<input type = "hidden" name="location" value = "house">
				<button>Find Gold!</button>
		</form>
		
		<form action ="/goldProcess" method = "POST">
				<h2>Casino! </h2>
				<p>(earn/takes 0-50 gold)</p>
				<input type = "hidden" name="location" value = "casino">
				<button>Find Gold!</button>
		</form>
		<form action ="/goldProcess" method = "POST">
				<h2>Spa! </h2>
				<p>(earn/takes 5-20 gold)</p>
				<input type = "hidden" name="location" value = "spa">
				<button>Find Gold!</button>
		</form>
		
		<h3>Activities:</h3>
		<textarea rows="20" cols="200" name = "name">
			<c:forEach var="oneFarm" items ="${locations}">
				<c:out value="${oneFarm}"></c:out>
			</c:forEach>
		
		</textarea>
		<form action ="/goldProcess" method = "POST">
			<input type = "hidden" name = "location" value = "reset"></input>
			<button >Reset</button>
		</form>
	</div>
</body>
</html>