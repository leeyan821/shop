<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import="shop.vo.ProdVO" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Best</title>
<link rel="stylesheet" href="css/best.css">
</head>
<body>
	<%@ include file="mainHeader.jsp" %>
	<div id="container">
	<h1>| Best 8 Item |</h1>
	<section id="wrapper">		
<%
	ArrayList<ProdVO> list = (ArrayList<ProdVO>)request.getAttribute("list");
	int cnt = 0; 
	if(!list.isEmpty()) {%>
		<% for(int i=0; i<list.size(); i++) {
			ProdVO prod = list.get(i); %>
			<article>
			<% if(prod.getPid().equals("cus1") || prod.getPid().equals("cus2")) {%>
				<a href="product.do?p=c">
					<img src="<%= prod.getImg() %>">
				</a>
			<%}else{%>
			<a href="prodSearch.do?pid=<%= prod.getPid()%>">
				<img src="<%= prod.getImg()%>">
			</a>
			<%} %>	
			<h2><%= prod.getName() %></h2>
			<p>가격 : <%= prod.getPrice() %></p>
		</article>
		<% 
			cnt++;
			if(cnt==8)
				break;
		} %>
	<%}else {
		out.print("<h2>none</h2>");
	}
	%>	
	</section>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>