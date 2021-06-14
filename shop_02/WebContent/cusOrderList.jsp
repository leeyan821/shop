<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import="shop.vo.CustomVO" %>
<%@ page import="shop.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custom Order List</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Kalam&display=swap');
	header {
		font-family: 'Kalam', cursive;
	}
</style>
<link rel="stylesheet" href="css/prodOrder.css">
</head>
<body>
<%
	ArrayList<CustomVO> list = (ArrayList<CustomVO>)request.getAttribute("custom");
	if(!list.isEmpty()) {
		int price = 0; 
		String pid = null;%>
	<header><a href="main.jsp">Sun</a></header>
	<div id="main">
	<div id="order">
	<h1>| 주문 |</h1>
	<% for(int i=0;i<1;i++){
		CustomVO prod = list.get(i); 
		price +=prod.getPrice();
		pid = prod.getId();
	%>
		<h3>type</h3>
		<p>선택 타입 : <%= prod.getName() %></p>
		<P>가격 : <%= prod.getPrice() %></P>
	<%} %>
	<% for(int i=1;i<list.size()-1;i++){
		CustomVO prod = list.get(i); %>
		<h3>flower</h3>
		<p>상세 선택 : <%= prod.getName() %></p>
		<P>색상 : <%= prod.getColor() %></P>
	<%} %>
	<% for(int i=list.size()-1;i<list.size();i++){
		CustomVO prod = list.get(i); 
		price +=prod.getPrice();%>
		<h3>plus</h3>
		<p>선택 타입 : <%= prod.getName() %></p>
		<P>가격 : <%= prod.getPrice() %></P>
	<%} %>			
		<h3>총 가격 <% out.print(price); %></h3>
	<% MemberVO member = (MemberVO)request.getAttribute("member");%>
	</div>
		<hr>
		<form action="customPlus.do" method="post">
		 배송지 입력<br>
		 <input type="text" name="address" value="${member.adress }">
		 <br>결제 수단<br>
		 <div>
			 <input type="radio" name="type" id="card" required>
			 <label for="card">카드</label>
			 <input type="radio" name="type" id="bank">
			 <label for="bank">무통장 입금</label>
			 <input type="radio" name="type" id="phone">
			 <label for="phone">휴대전화</label>
		 </div>
		 <input type="hidden" name="pid" value="<%= pid%>">
		 <input type="submit" value="결제하기">	 
		</form>
	</div>
	<%} %>
</body>
</html>