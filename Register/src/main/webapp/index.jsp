<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>메인페이지</title>
<link rel="stylesheet" href="/resources/userCss/main.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap"
	rel="stylesheet">
</head>
<body>
	<!-- main : 로그인을 하지 않은 경우 -->
	<c:if test="${sessionScope.id eq null }">
		<div id="container">
			<header>
				<div id="user">
					<a href="/register/login"> <img src="/resources/img/login.png"
						alt="로그인">
					</a>
				</div>
			</header>
			<main>
				<h1>야, 너두 코딩할수있어</h1>
				<div id="metoo">
					<img src="/resources/img/metoo.png" alt="야나두">
				</div>
			</main>
			<footer>
				<div id="kakao">
					<img src="/resources/img/kakao.png" alt="카카오">
					<p onclick="popup();">Add to KakaoTalk</p>
				</div>
				<div id="git">
					<img src="/resources/img/git.png" alt="깃헙"> <a
						href="https://github.com/heechae96" target="_blank">
						<p>Git for developers</p>
					</a>
				</div>
			</footer>
		</div>
	</c:if>

	<!-- mainLogin : 로그인을 한 경우 -->
	<c:if test="${sessionScope.id ne null }">
		<div id="container">
			<header>
				<nav>
					<div id="add">
						<img src="/resources/img/add.png" alt="add"> <a
							href="">수강 신청</a>
					</div>
					<div id="check">
						<img src="/resources/img/checked.png" alt="chechk & modify"> <a
							href="">확인 / 정정</a>
					</div>
					<div id="logout">
						<img src="/resources/img/logout.png" alt="logout"> <a
							href="/register/logout">로그아웃</a>
					</div>
					<div id="modify">
						<img src="/resources/img/user.png" alt="마이페이지"> <a
							href="/register/userInfo?id=${sessionScope.id }">${sessionScope.id }</a>
					</div>
				</nav>
			</header>
			<main>
				<h1>야, 너두 코딩할수있어</h1>
				<div id="metoo">
					<img src="/resources/img/metoo.png" alt="야나두">
				</div>
			</main>
			<footer>
				<div id="kakao">
					<img src="/resources/img/kakao.png" alt="카카오">
					<p onclick="popup();">Add to KakaoTalk</p>
				</div>
				<div id="git">
					<img src="/resources/img/git.png" alt="깃헙"> <a
						href="https://github.com/heechae96" target="_blank">
						<p>Git for developers</p>
					</a>
				</div>
			</footer>
		</div>

	</c:if>
	<script>
		function popup() {
			var url = "/resources/img/kakaoQR.JPG";
			var name = "popup";
			var options = "width = 500, height = 500";
			window.open(url, name, options);
		}
	</script>
</body>
</html>