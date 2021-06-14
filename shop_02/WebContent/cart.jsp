<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import="shop.vo.CartVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart</title>
<link rel="stylesheet" href="css/cart.css">
</head>
<body>
<%@ include file="mypageHeader.jsp" %>
<%
	ArrayList<CartVO> list = (ArrayList<CartVO>)request.getAttribute("list");
	if(!list.isEmpty()) {%>
	<table>
		<tr class="top"><th>이미지</th><th>상품</th><th>가격</th><th>수량</th><th>선택</th></tr>
		<%
		for(int i=0;i<list.size();i++){
			CartVO cart = list.get(i); %>
		<tr>
			<td class="img"><a href="prodSearch.do?pid=<%= cart.getPid()%>"><img alt="product" src="<%= cart.getImage() %>"></a></td>
			<td><h2><%= cart.getName() %></h2></td>
			<td><h2><%= cart.getPrice() %></h2></td>
			<td><h2><%= cart.getCount() %></h2></td>
			<td class="delete">
				<input type="button" value="삭제" onclick="location.href='delete.do?c=<%=cart.getId()%>'">
				<p></p>
				<input type="button" value="구매" onclick="location.href='cartOrder.do?pid=<%=cart.getPid()%>&count=<%= cart.getCount() %>'">
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