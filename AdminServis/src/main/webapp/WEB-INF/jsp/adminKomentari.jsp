<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Komentari : View all</title>
<style>
table, th, td {
  border: 1px solid black;
}

body {	
	background: linear-gradient(90deg, #fafbfc, #00FFFF);
}

.container{
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

</style>
</head>

<body>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th>ID Korisnika</th>
					<th>Komentar</th>
					<th> Status</th>
					
					
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${komentari}" var="komentar">
					<tr>
						<td><c:out value="${komentar.kreatorKomentaraID}" /></td>
						
						<td><c:out value="${komentar.tekstKomentara}" /></td>
						<td><c:out value="${komentar.statusKomentara}" /></td>
						<td>
							<c:if test="${komentar.statusKomentara=='neodobren'}">
							<form action="/adminservisapp/adminservlet/komentari/odobri/${komentar.identifikacioniBroj}" method="get">
								<input type="submit" value="Odobri"></input>
							</form>
						</c:if>
						</td>
						
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>

</html>