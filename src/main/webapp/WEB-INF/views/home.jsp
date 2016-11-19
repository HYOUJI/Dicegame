<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h3>Dice Game</h3>
	<form action="/dicegame/startDiceGame" method="post">
	<input type="text" name="playerId"/>
	<input type="submit" name="play" value="Play"/><br/>
	</form>
	
	<form action="/dicegame/configureGame" method="post">
	<input type="button" name="configure" value="Configure"/>
	<input type="button" name="exit" value="Exit" 
	onclick="self.close()"/>
	</form>

</body>
</html>
