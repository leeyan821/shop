<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/cart.css">
</head>
<body>
<% 
	String id = (String)session.getAttribute("id");
	if(id != null){
%>	
	<script>		
    (function() {
      var reply = confirm("장바구니에 추가되었습니다. 장바구니로 이동하시겠습니까?");
      if(reply == true){
    	 location.href = "http://localhost:8080/shop_02/cart.do"; 
      }     	
      else
      	history.go(-1);	
    }());
  </script>	
 <%}else{%> 
 	<script>		
    (function() {
      alert("로그인이 필요합니다.");
      location.href = "/shop_02/logIn.jsp";
    }());
  </script>
 <% }%>
</body>
</html>