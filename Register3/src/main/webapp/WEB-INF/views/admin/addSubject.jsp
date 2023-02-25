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
				<a href="/home"><img src="/resources/img/home.png" alt="홈"></a>
			</div>
		</header>
		<main>
			<h1>과목 추가</h1>
			<form action="/subject/insert" method="post" onsubmit="return dateChk()">
				<div id="inputBox">
					<div id="subjectName">
						<input type="text" name="subjectName" placeholder="과목명" required>
					</div>
					<div id="name">
						<input type="text" name="name" placeholder="교수명" required>
					</div>
					<div id="maxNum">
						<input type="number" name="maxNo" min=1 placeholder="인원 제한" required>
					</div>
					<!-- 타입이 date인 경우 placeholder가 연.월.일로 고정됨 -->
					<div id="start">
						<input type="date" name="startDate" data-placeholder="개강일" required
							aria-required="true">
					</div>
					<div id="end">
						<input type="date" name="endDate" data-placeholder="종강일" required
							aria-required="true">
					</div>
					<div id="submit">
						<button>완료</button>
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
		
		function dateChk() {
			let start = document.querySelector('input[name=startDate]');
			let end = document.querySelector('input[name=endDate]');
			if(start.value > end.value){
				alert("종강일이 개강일보다 빠를 수 없습니다");
				return false;
			}else{
				return true;
			}
		}
	</script>
</body>

</html>