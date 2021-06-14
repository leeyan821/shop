<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import="shop.vo.CartVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/order.css">
<title>Order List</title>
</head>
<body>
	<%@ include file="mypageHeader.jsp" %>
<%
	ArrayList<CartVO> list = (ArrayList<CartVO>)request.getAttribute("list");
	if(!list.isEmpty()) {%>
	<h2>| 주문 내역 |</h2>
	<table>
		<tr class="top"><th>이미지</th><th>상품</th><th>가격</th><th>수량</th><th>주문일</th><th>주소</th><th>선택</th></tr>
		<%
		for(int i=0;i<list.size();i++){
			CartVO cart = list.get(i); %>
		<tr>
			<% if(cart.getPid().equals("cus1") || cart.getPid().equals("cus2")) {%>
				<td class="img"><img alt="product" src="<%= cart.getImage() %>"></td>
			<%}else{%>
			<td class="img"><a href="prodSearch.do?pid=<%= cart.getPid() %>"><img alt="product" src="<%= cart.getImage() %>"></a></td>
			<%} %>
			<td><h2><%= cart.getName() %></h2></td>
			<td><h2><%= cart.getPrice() %></h2></td>
			<td><h2><%= cart.getCount() %></h2></td>
			<td><h2><%= cart.getDate() %></h2></td>
			<td><h2><%= cart.getAddress() %></h2></td>
			<td class="delete">
				<input type="button" value="수정" onclick="location.href='orderList.do?o=<%= cart.getId()%>'">
			</td>
		</tr>
	<%} 	
	}else{
		out.print("<h2>none</h2>");
	}
	%>
	</table>
	<%@ include file="footer.jsp" %>
</body>
</html>