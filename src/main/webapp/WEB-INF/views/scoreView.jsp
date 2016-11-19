<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Score</title>
</head>
<body>
	<h1>Score</h1>
	<table width="200">	
	<th width="80">name</th><th>win</th><th>lose</th><th>draw</th>
	<c:forEach var="scores" items="${scores}">
		<tr align="center">
		<td >${scores.name}</td><td>${scores.win}</td><td>${scores.lose}</td><td>${scores.draw}</td>
		</tr> 
	</c:forEach>
	<tr>
	<td colspan="4" align="center">
		<form action="/dicegame">
		<input type="submit" value="Retry"/>
		</form>
	</td>
	</tr>
	</table>	
	
</body>
</html>