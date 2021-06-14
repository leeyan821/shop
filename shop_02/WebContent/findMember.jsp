<%@page import="javax.sound.midi.SysexMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="shop.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID/Password 찾기</title>
</head>
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
		<div id="container">			
			<form action="mailchk.do" method="post">
				<h2>이메일 입력</h2>		
				<input type="email" name="mail" placeholder="이메일 입력" required><br>		
				<input type="submit" value="확인">					
			</form>	
	<%
		MemberVO member = (MemberVO)request.getAttribute("member");
	if(member != null) {
	%>
	<form action="logIn.jsp" method="post">
		<h3>Information</h3>
		ID<input type="text" name="id" readonly value="${member.id }"> <br>
		Password<input type="text" name="pwd" readonly value="${member.pwd }"> <br>
		<input type="submit" value="확인">
	</form>
	<% }else{ %>
			<form><p class="p">${error}</p></form>		
	<% } %>									
	</div>		
</body>
</html>