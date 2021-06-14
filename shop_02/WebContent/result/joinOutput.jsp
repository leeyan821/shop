<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Kalam&display=swap');
	header {
		font-family: 'Kalam', cursive;
	}
</style>
<link rel="stylesheet" href="css/joinAgree.css">
</head>
<%
	String re = (String)request.getAttribute("error");
	if(re.equals("over")){%>
		<script>
			alert('이미 존재하는 아이디입니다.');
			history.go(-1);
		</script>
<%	}else{%>
<body>	 
	 <header><a href="main.jsp">Sun</a></header>
	 <div id="container">	
	 	<h2>${id }님 가입이 완료되었습니다.</h2>
	 	<form method="post" action="main.jsp">
		 	<input type="submit" value="HOME">
	 	</form>
	 </div>
</body>
<%} %>
</html>