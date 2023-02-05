<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="/resources/userCss/findPassword.css">
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
			<h1>비밀번호 찾기</h1>
			<form action="/register/findPw" method="post">
				<div id="inputBox">
					<div id="id">
						<input type="text" name="id" placeholder="아이디" autofocus required>
					</div>
					<div id="name">
						<input type="text" name="name" placeholder="이름" required>
					</div>
					<div id="phone">
						<input type="tel" name="phone" placeholder="휴대폰 번호" required>
					</div>
					<div id="submit">
						<button type="submit">완료</button>
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
					href="https://github.com/heechae96/KH_RegisterProject2" target="_blank">
					<p>Git for developers</p>
				</a>
			</div>
		</footer>
	</div>
	<script>
		function popup() {
			var url = "/resources/img/kakaoQR.JPG";
			var name = "popup";
			var options = "width = 750, height = 925";
			window.open(url, name, options);
		}
	</script>
</body>

</html>