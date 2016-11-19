<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Play DiceGame</title>
</head>
<body>
	<form action="/dicegame/rollingDice" method="post">
	<table border="1" width="600px">
		<tr>
		<td  colspan="2"><center><h2>Dice Game</h2></center></td>		
		</tr>
		<tr>
		<td><center><h3>Face Value</h3></center></td>
		<td><center><h3>Current State</h3></center></td>
		</tr>
		<tr>
			<td width="300px" >			
				<br/>${playerId}'s Face Value : ${playerValue} <br/>
				AlphaDice's Face Value : ${alphaValue} <br/><br/>
			</td>
			<td width="300px">		
				<br/>${playerId} : ${curCellForPlayer} <br/>
				AlphaDice : ${curCellForAlpha} <br/><br/>
			</td>
		</tr>
		<tr>
		<td colspan="2"><center><input type="submit" value="roll"/></center></td>
		</tr>
	</table>
	</form>

</body>
</html>