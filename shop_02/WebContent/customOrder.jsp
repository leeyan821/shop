<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="shop.vo.ProdVO" %>
<%@ page import="shop.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custom-product Order</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Kalam&display=swap');
	header {
		font-family: 'Kalam', cursive;
	}
</style>
<link rel="stylesheet" href="css/customOrder.css">
</head>
<% if(session.getAttribute("id")==null){%>
	<script>
		alert('로그인 후 이용 가용합니다.');
		location.href = "/shop_02/logIn.jsp";
	</script>
<% }%>
<body>
	<header><a href="main.jsp">Sun</a></header>
   	<div id="main">	
   	<h1>| 주문 제작 |</h1>
   	<h2>${error }</h2>
      <form action="customOrder.do" method="post">      
          <ul>
            <li>
            <h3 class="name"><label for="type">type</label></h3>
             <label><input type="radio" name="type" value="cus1" required>type1</label>
			 <label><input type="radio" name="type" value="cus2">type2</label>
            </li>
            <li>
             <h3 class="name"><label for="flower">flower</label></h3>
             <label><input type="checkbox" name="flower" value="cus3">장미-red</label>
			 <label><input type="checkbox" name="flower" value="cus4">장미-white</label>
			 <label><input type="checkbox" name="flower" value="cus5">튤립-pink</label>
			 <label><input type="checkbox" name="flower" value="cus6">튤립-purple</label><br>
             <label><input type="checkbox" name="flower" value="cus7">수국-pink</label>
             <label><input type="checkbox" name="flower" value="cus8">수국-purple</label>
             <label><input type="checkbox" name="flower" value="cus9">안개꽃-white</label>
             <label><input type="checkbox" name="flower" value="cus10">안개꽃-pink</label><br>
             <label><input type="checkbox" name="flower" value="cus11">리시안셔스</label>
             <label><input type="checkbox" name="flower" value="cus12">프리지아</label>
             <label><input type="checkbox" name="flower" value="cus13">백합</label>
            </li>
            <li>
              <h3 class="name"><label for="plus">plus</label></h3>
             <label><input type="radio" name="plus" value="cus14" required>plus1</label>
			 <label><input type="radio" name="plus" value="cus15">plus2</label>
			 <label><input type="radio" name="plus" value="cus16">plus3</label>
            </li>
          </ul>             
        <div id="button">           
          <input type="submit" value="구매하기">
        </div>
      </form>
</div>
</body>
</html>