<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import="shop.vo.CartVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/order.css">
<title>Order Update</title>
</head>
<body>
<%@ include file="mypageHeader.jsp" %>
<%	CartVO order = (CartVO)request.getAttribute("order");
	if(order!=null) {%>
	<table>
		<tr class="top"><th>이미지</th><th>상품</th><th>가격</th><th>수량</th><th>주문일</th><th>주소</th><th>선택</th></tr>
		<tr>		
			<td class="img"><a href="prodSearch.do?pid=<%= order.getPid() %>"><img alt="product" src="<%= order.getImage() %>"></a></td>
			<td><h2><%= order.getName() %></h2></td>
			<td><h2><%= order.getPrice() %></h2></td>
			<td><h2><%= order.getCount() %></h2></td>
			<td><h2><%= order.getDate() %></h2></td>
			<td><h2><%= order.getAddress() %></h2></td>
			<td class="delete">
				<input type="button" value="배송 취소" onclick="location.href='delete.do?a=<%= order.getId()%>&count=<%= order.getCount() %>'">
			</td>
		</tr>
	 	</table>
	 	<div class="f">
	 		
			<form action="orderUpdate.do" method="post">
				<h1>배송지 변경</h1>
				<input type="text" name="address" value="<%= order.getAddress() %>"><br>
				<h1>수량 변경</h1>
				<input type="number" name="count" min=1 max=50 value="<%= order.getCount() %>"><br>
				<input type="hidden" name="name" value="<%= order.getName() %>">
				<input type="hidden" name="beCnt" value="<%= order.getCount() %>">
				<input type="submit" value="변경">
			</form>
		</div>
	<%} else{
		out.print("<h2>none</h2>");
		}%>	
	<%@ include file="footer.jsp" %>
</body>
</html>