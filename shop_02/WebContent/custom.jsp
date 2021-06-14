<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import="shop.vo.CustomVO" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custom-made</title>
<link rel="stylesheet" href="css/custom.css">
</head>
<body>
	<%@ include file="mainHeader.jsp" %>
	<div id="container">
		<h1>| Custom-made |</h1>
		<hr>
		<h1>Type</h1>
<%
	ArrayList<CustomVO> list = (ArrayList<CustomVO>)request.getAttribute("list");
	if(!list.isEmpty()) {%>
	<section id="wrapper">
		<% for(int i=0; i<2; i++) {
			CustomVO prod = list.get(i); %>					
			<article>		
				<img src="<%= prod.getImg() %>">
				<h2><%= prod.getName() %></h2>
				<p><%= prod.getDetail() %></p>
			</article>	
		<%} %>
		</section>
		<h1>Flower</h1>
		<section id="wrapper">
		<% for(int i=2; i<10; i++) {
			CustomVO prod = list.get(i); %>					
			<article>		
				<img src="<%= prod.getImg() %>">
				<h2><%= prod.getName() %></h2>
				<p><%= prod.getDetail() %></p>
			</article>		
		<%} %>
		<% for(int i=10; i<13; i++) {
			CustomVO prod = list.get(i); %>	
			<article>		
				<img src="<%= prod.getImg() %>">
				<h2><%= prod.getName() %></h2>
				<p><%= prod.getDetail() %></p>
			</article>		
		<%} %>	
		</section>
		<h1>plus</h1>
		<section id="wrapper">
		<% for(int i=13; i<16; i++) {
			CustomVO prod = list.get(i); %>	
			<article>		
				<img src="<%= prod.getImg() %>">
				<h2><%= prod.getName() %></h2>
				<p><%= prod.getDetail() %></p>
			</article>
		<%} %>
		</section>
	<%}else {
		out.print("<h2>none</h2>");
	}
	%>	
	</div>
	<form action="customOrder.jsp" method="post">
		<input type="submit" name="send" value="주문하기">
	</form>
	<%@ include file="footer.jsp" %>
</body>
</html>