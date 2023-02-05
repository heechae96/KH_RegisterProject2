<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="/resources/userCss/login.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap"
	rel="stylesheet">
</head>
<body>
	<div id="container">
		<header>
			<div id="home">
				<a href="/"><img src="/resources/img/home.png" alt="홈"></a>
			</div>
		</header>
		<main>
			<h1>로그인</h1>
			<form action="/register/login" method="post">
				<div id="inputBox">
					<div id="id">
						<img src="/resources/img/id.png" alt="아이디"> <input
							type="text" name="id" placeholder="아이디" required autofocus>
					</div>
					<div id="pwd">
						<img src="/resources/img/pwd.png" alt="비밀번호"> <input
							type="password" name="pw" placeholder="비밀번호" required>
					</div>
					<div id="submit">
						<button type="submit">완료</button>
					</div>
					<div id="action">
						<div id="find">
							<a href="javascript:void(0)"><p onclick="goFindPw()">비밀번호 찾기</p></a>
						</div>
						<div id="enroll">
							<a href="javascript:void(0)"><p onclick="goEnroll()">회원가입</p></a>
						</div>
					</div>
				</div>
			</form>
		</main>
		<footer>
			<div>
				<img src="/resources/img/kakao.png" alt="카카오">
				<p onclick="popup();">Add to KakaoTalk</p>
			</div>
			<div>
				<img src="/resources/img/git.png" alt="깃헙"> <a
					href="https://github.com/heechae96" target="_blank">	
					<p>Git for developers</p></a>
			</div>
		</footer>
	</div>
	<script>
		function popup() {
			var url = "/resources/img/kakaoQR.JPG";
			var name = "popup";
			var options = "width = 500, height = 500";
			window.open(url, name, options);
		}
		function goEnroll(){
			location.href = ("/register/enroll");
		}
		function goFindPw(){
			location.href = ("/register/findPw");
		}
	</script>
</body>
</html>