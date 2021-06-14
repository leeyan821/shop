<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Kalam&display=swap');
	header {
		font-family: 'Kalam', cursive;
	}
</style>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<header><a href="main.jsp">Sun</a></header>		
	<%
		if(session.isNew() || session.getAttribute("id")==null)
		{%>
		<%		
			String msg = (String)request.getAttribute("error");
			if(msg==null)
				msg="";
		%>	
		<div id="container">	
			<form action="login.do" method="post">			
				<input type="text" name="id" placeholder="아이디 입력" required><br>		
				<input type="password" name="pwd" placeholder="비밀번호 입력" required><br>
				<input type="submit" value="로그인">					
			</form>				
			<div id="plus">
				<p><%= msg +"<br><p>"%><p>
				<a href="findMember.jsp">아이디 / 비밀번호 찾기  | </a>
				<a href="joinagree.jsp"> 회원가입</a>
			</div>					
		</div>		
		<%}%>
</body>
</html>