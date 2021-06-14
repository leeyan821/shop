<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>약관동의</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Kalam&display=swap');
	header {
		font-family: 'Kalam', cursive;
	}
</style>
<link rel="stylesheet" href="css/joinAgree.css">
</head>
<body>	 
	 <header><a href="main.jsp">Sun</a></header>
	 <div id="container">	
	 	<p>${error }</p>
	 	<p>- 개인정보 수집 및 이용에 동의합니다. -</p>
	 	<form method="post" action="join.jsp">
	 		<input type="checkbox" name="agree" value="agree" required>동의<br>
	 		<div id="send">
		 		<input type="submit" value="가입하기">
	 		</div>
	 	</form>
	 </div>
</body>
</html>