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
	String re = (String)request.getAttribute("re");
	if(re!=null){
%>
	<script>
		alert("제품수가 부족합니다.");
		history.go(-1);	
	</script>
<%} else{ %>
	<script>
		alert("결제가 완료되었습니다.");
		location.href = "/shop_02/orderList.do?o=w";
	</script>
	<%} %>
</body>
</html>