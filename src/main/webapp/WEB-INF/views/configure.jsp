<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Configure</title>
</head>
<body>

	<h1>Change your map</h1>
	<form id="configure" action="/dicegame/setconfigure" method="post">
		<input type="text" size="4" name="originalCell" /> 
		→ <input type="text" size="4" name="replacedCell" />
		<button type="submit">Add</button>
	</form><br/>

	<table>
		<tr>
			<td>
				<form action="/dicegame/initconfigure" method="post">
					<button type="submit">Init</button>
				</form>
			</td>
			<td>
				<form action="/dicegame">
					<button type="submit">Done</button>
				</form>
			</td>
		</tr>
	</table>
	
	<table width="200">
		<tr>
		<td colspan="2"><h3>This is your map.</h3></td>
		</tr>
		<tr>
			<td>
			<c:forEach var="i" begin="1" end="15" step="1">     
		      ${i} → ${replacedCells[i]} <br>
			</c:forEach>
			</td>
			<td>
			<c:forEach var="i" begin="16" end="29" step="1">     
     		 ${i} → ${replacedCells[i]} <br>
			</c:forEach>
			</td>
		</tr>
	</table>
</body>
</html>