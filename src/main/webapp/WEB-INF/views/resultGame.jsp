<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>
	<h1>Result </h1> <h2>${message}</h2>
	<table border="1" width="200">
		<th>player</th><th>score</th>
		<tr>
			<td>${playerId}</td>
			<td align="center">${curCellForPlayer}</td>
		</tr>
		<tr>
			<td>AlphaDice</td>
			<td align="center"> ${curCellForAlpha}</td>
		</tr>
	</table> <br/>
	<form action="/dicegame/scoreview" method="GET">
	<input type="submit" value="Score"/>
	</form>
	<form action="/dicegame">
	<input type="submit" value="Retry"/>
	</form>
	
</body>
</html>