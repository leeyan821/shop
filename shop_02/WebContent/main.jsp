<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>flower Sun</title>
	<style>
</style>
	<link rel="stylesheet" href="css/main.css">
<script>
	window.onload = function() {
		var change = document.getElementById("change");
		change.addEventListener("mouseover",changePic);
		change.addEventListener("mouseout",originPic);
		
		function changePic() {
		    change.src = "images/photo4.png";
		}
	    function originPic() {	    	
	    	change.src = "images/photo1.png";	
	    }
	};
</script>
</head>
<body>
	<%@ include file="mainHeader.jsp" %>
	<hr>
	<section id="photo">
		<a href="product.do?p=c"><img src="images/photo1.png" id="change"></a>
	</section>
	<h1>| 이번 달 추천 상품 |</h1>
	<section id="wrapper">		
		<article>
			<a href="prodSearch.do?pid=p01">
				<img src="images/p1.jpg">
			</a>
			<h2>Pink rose</h2>
			<p>price 23,000</p>
		</article>
		<article>
			<a href="prodSearch.do?pid=p03">
				<img src="images/p5.jpg">
			</a>
			<h2>Red rose</h2>
			<p>price 23,000</p>
		</article>
		<article>
			<a href="prodSearch.do?pid=p05">
				<img src="images/p2.jpg">
			</a>	
			<h2>Spring</h2>
			<p>price 25,000</p>
		</article>
		<article>
			<a href="prodSearch.do?pid=p06">
				<img src="images/p4.jpg">
			</a>
			<h2>Winter</h2>
			<p>price 35,000</p>
		</article>
		<article>
			<a href="prodSearch.do?pid=p07">
				<img src="images/p3.jpg">
			</a>	
			<h2>Tulip</h2>
			<p>price 18,000</p>
		</article>
		<article>
			<a href="prodSearch.do?pid=p08">
				<img src="images/p6.jpg">
			</a>	
			<h2>White rose</h2>
			<p>price 23,000</p>
		</article>
	</section>
	<%@ include file="footer.jsp" %>
	
</body>
</html>