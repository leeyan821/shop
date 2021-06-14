<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="shop.vo.ProdVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Order</title>
<link rel="stylesheet" href="css/prod.css">
</head>
<body>
	<%@ include file="mainHeader.jsp" %>
	<div id="container">
<%	ProdVO product = (ProdVO)request.getAttribute("product");
	if(product!=null) { %>	
	<div id="screen">
	<div id="img">
		<img alt="product" src="${product.img }">
	</div>
	<div id="main">
		<h1>${product.name }</h1>
		<P>가격 ${product.price }</P>
		<hr>
		<form action="cartPlus.do" method="post">
		 수량<br>
		 <input type="number" name="count" min="0" max="50" value="1">
		 추가 제품<br>
		 <select name="acc">
		 	<option selected>none</option>
		 	<option value="acc1">acc1</option>
		 	<option value="acc2">acc2</option>
		 	<option value="acc3">acc3</option>
		 </select>
		 <input type="hidden" name="pid" value="${product.pid }">
 		 <input type="submit" name="cart" value="장바구니">
		 <input type="submit" name="cart" value="구매">	 
		</form>
	</div>
	</div>	
	<div id="detail">
		<hr>
		<h2>| 제품 설명 |</h2>	
		<p>${product.detail }</p>
	</div>
	<%} %>		
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>