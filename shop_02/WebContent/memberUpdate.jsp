<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="shop.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/mypage.css">
<title>정보 수정</title>
</head>
<body>
<%@ include file="mypageHeader.jsp" %>
	<div id="container">
	<h1>| 회원 정보 |</h1>
	<%
		MemberVO member = (MemberVO)request.getAttribute("member");
	if(member != null) {
	%>
	<form action="memberUpdate.do" method="post">
		아이디<input type="text" name="id" readonly value="${member.id }"> <br>
		이름<input type="text" name="name" value="${member.name }"> <br>
		이메일<input type="text" name="mail" value="${member.mail }"> <br>
		전화번호<input type="text" name="phone" value="${member.phone }"> <br>	
		주소<input type="text" name="adress" value="${member.adress }"> <br>	
		<input type="submit" value="확인">
	</form>
	<% } %>								
	</div>
</body>
</html>