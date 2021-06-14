<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="shop.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Kalam&display=swap');
	header {
		font-family: 'Kalam', cursive;
	}
</style>
<link rel="stylesheet" href="css/join.css">
</head>
<body>
   	<header><a href="main.jsp">Sun</a></header>
   	<div id="idbox">
   	<fieldset>	
   	<form action="idcheck.do" method="post">
   	${error } 	
   	<ul>
        <li>
         <h3 class="name">
              <label for="uid">아이디</label>
         </h3>
         <%
			MemberVO member = (MemberVO)request.getAttribute("member");
			if(member == null) {%>	            
              <input type="text" name="uid" value="${id }">
         <%}else{ %>
         	  <input type="text" name="uid" placeholder="아이디를 입력하세요" required>
         <%} %>
         	  <p class="p">${iderror }</p>
              <input type="submit" value="중복체크" name="chk">                       	
          </li>
      </ul>         
      </form>
      <form action="join.do" method="post">      
          <ul>
            <li>
              <h3 class="name">
                <label for="pwd">비밀번호</label>
              </h3>
              <input type="password" name="pwd" placeholder="비밀번호를 입력하세요" required> 
            </li> 
            <li>
              <h3 class="name">
                <label for="uname">이름</label>
              </h3>
              <input type="text" name="uname" required> 
            </li>
            <li>
              <h3 class="name">
                <label for="mail">본인 확인 이메일</label>
              </h3>
              <input type="email" name="mail" placeholder="예)Sun21@**.com" required> 
            </li>
            <li>
              <h3 class="name">
                <label for="umail">휴대전화</label>
              </h3>
              <input type="tel" name="umail" placeholder="예)01099999999" required> 
            </li>
            <li>
              <h3 class="name">
                <label for="adress">주소</label>
              </h3>
              <input type="text" name="adress" required> 
            </li>
          </ul>             
        <div id="button">           
          <input type="hidden" name="uid" value="${id }">
          <input type="submit" value="가입하기" name="join">
        </div>
      </form>
      </fieldset>
</div>  
</body>
</html>