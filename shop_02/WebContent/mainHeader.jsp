<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");
	if(id==null){
%>
	<header>
		<a href="main.jsp"><img src="images/logo.png"></a>
	</header>	
	<nav>
		<ul>
			<li><a href="product.do?p=b">Best</a></li>
			<li><a href="product.do?p=p">product</a></li>
			<li><a href="product.do?p=c">custom-made</a></li>
			<li><a href="product.do?p=a">accessory</a></li>
			<li><a href="sale.jsp">sale</a></li>
		</ul>	
		<ul id="top">
			<li><a href="logIn.jsp">로그인</a></li>
			<li><a href="joinagree.jsp">회원가입</a></li>
			<li><a href="mypage.do?p=w">마이 페이지</a></li>
		</ul>		
	</nav>
<%} else{%>
	<header>
		<a href="main.jsp"><img src="images/logo.png"></a>
	</header>	
	<nav>
		<ul>
			<li><a href="product.do?p=b">Best</a></li>
			<li><a href="product.do?p=p">product</a></li>
			<li><a href="product.do?p=c">custom-made</a></li>
			<li><a href="product.do?p=a">accessory</a></li>
			<li><a href="sale.jsp">sale</a></li>
		</ul>	
		<ul id="top">
			<li><a href="logout.do">로그아웃</a></li>
			<li><a href="mypage.do?p=w">마이 페이지</a></li>
		</ul>		
	</nav>
<%} %>
</body>
</html>