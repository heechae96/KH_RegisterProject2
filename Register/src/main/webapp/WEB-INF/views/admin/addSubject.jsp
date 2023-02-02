<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>과목 추가</title>
<link rel="stylesheet" href="/resources/adminCss/addSubject.css">
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
			<h1>과목 추가</h1>
			<form action="/admin/insert" method="post">
				<div id="inputBox">
					<div id="subjectName">
						<input type="text" name="subjectName" placeholder="과목명">
					</div>
					<div id="name">
						<input type="text" name="name" placeholder="교수명">
					</div>
					<div id="maxNum">
						<input type="number" name="maxNum" placeholder="최대 수강 인원">
					</div>
					<!-- 타입이 date인 경우 placeholder가 연.월.일로 고정됨 -->
					<div id="start">
						<input type="date" name="start" data-placeholder="개강일" required
							aria-required="true">
					</div>
					<div id="end">
						<input type="date" name="end" data-placeholder="종강일" required
							aria-required="true">
					</div>
					<div id="submit">
						<button>완료</button>
					</div>
				</div>
			</form>
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