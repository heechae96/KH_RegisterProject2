<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<link rel="stylesheet" href="/resources/userCss/signup.css">
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
			<h1>회원가입</h1>
			<form action="/register/enroll" method="post" name="joinform"
				onsubmit="return dupIdChk()">
				<div id="inputBox">
					<button id="doubleChk" onclick="chk()">중복확인</button>
					<input type="hidden" name="chkUserId">
					<div id="id">
						<input type="text" name="viewId" placeholder="아이디" required
							autofocus>
					</div>
					<div id="pw">
						<input type="password" name="pw" placeholder="비밀번호" required>
					</div>
					<div id="name">
						<input type="text" name="name" placeholder="이름" required>
					</div>
					<div id="phone">
						<input type="tel" name="number" placeholder="'-'를 제외한 휴대번호"
							required>
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
					href="https://github.com/heechae96" target="_blank">	
					<p>Git for developers</p></a>
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
		function chk() {
			if (document.joinform.viewId.value == "") {
				alert("사용자 아이디를 입력해주세요.");
				document.joinform.viewId.focus();
				return;
			}
			var url = "/register/idChk?id=" + document.joinform.viewId.value;
			window.open(url, "chkIdForm", "width=800, height=500");
		}

		function dupIdChk() {
			var dupId = document.querySelector("[type=hidden]").value;
			if (dupId == "") {
				alert("아이디 중복확인이 필요합니다.")
				return false;
			} else {
				return true;
			}
		}
	</script>
</body>

</html>