<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="shop.vo.ProdVO" %>
<%@ page import="shop.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Kalam&display=swap');
	header {
		font-family: 'Kalam', cursive;
	}
</style>
<link rel="stylesheet" href="css/prodOrder.css">
</head>
<body>
<%	int count = (int)request.getAttribute("cnt");
	ProdVO prod = (ProdVO)request.getAttribute("prod");
	MemberVO member = (MemberVO)request.getAttribute("member");
	ProdVO accProd = (ProdVO)request.getAttribute("accProd");
	int money = 0;
	if(accProd!=null)
		money = accProd.getPrice();
	int price = count*(prod.getPrice())+money;
	if(prod!=null) { %>	
	<header><a href="main.jsp">Sun</a></header>
	<div id="main">
	<div id="order">
	<h1>| 주문 |</h1>
		<h3>상세 정보</h3>
		<p>제품 이름 : ${prod.name }</p>
		<P>가격 : ${prod.price }</P>
		<P>수량 : <% out.print(count); %></P>	
		<%if(accProd!=null) {%>	
		<P>추가 제품 : ${accProd.name }   가격 : ${accProd.price }</P>
		<%} %>		
		<h3>총 가격 <% out.print(price); %></h3>
	</div>
		<hr>
		<form action="orderPlus.do" method="post">
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
		 <input type="hidden" name="pid" value="${prod.pid }">
		 <input type="hidden" name="cnt" value="<%= count %>">
		 <%if(accProd!=null) {%>
		 <input type="hidden" name="apid" value="${accProd.pid }">
		 <%} %>
		 <input type="submit" value="결제하기">	 
		</form>
	</div>
	<%} %>		
</body>
</html>