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
</head>

<body>
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
						
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

</body>

</html>