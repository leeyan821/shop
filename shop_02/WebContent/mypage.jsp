<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="shop.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My page</title>
<link rel="stylesheet" href="css/mypage.css">
</head>
<body>
	<%@ include file="mypageHeader.jsp" %>
	<div id="container">
	<h1>| 회원 정보 |</h1>
	<%
		MemberVO member = (MemberVO)request.getAttribute("member");
		if(member != null) {
	%>
		<h3>아이디: ${member.id }</h3>
		<h3>이름: ${member.name }</h3>
		<h3>이메일: ${member.mail }</h3>
		<h3>전화번호: ${member.phone }</h3>
		<h3>주소: ${member.adress }</h3>
		<form action="mypage.do?p=up" method="post">
			<input type="submit" value="수정하기">
		</form>
	</div>	
	<%} else{ %>
		<script>
			alert("로그인이 필요합니다.");
			location.href = "/shop_02/logIn.jsp";
		</script>
	<%} %>	
	<%@ include file="footer.jsp" %>
</body>
</html>