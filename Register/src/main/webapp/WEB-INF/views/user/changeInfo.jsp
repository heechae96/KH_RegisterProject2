<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>정보 수정</title>
<link rel="stylesheet" href="/resources/userCss/infoChange.css">
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
			<h1>마이페이지</h1>
			<form action="/register/update" method="post">
				<div id="inputBox">
					<div id="id">
						<span>아이디</span> <input type="text" id="id" name="id"
							value="${user.userId }" readonly>
					</div>
					<div id="pw">
						<span>비밀번호</span> <input type="text" id="pw" name="pw"
							value="${user.userPw }">
					</div>
					<div id="name">
						<span>이름</span> <input type="text" id="name" name="name"
							value="${user.userName }">
					</div>
					<div id="phone">
						<span>휴대번호</span> <input type="tel" id="phone" name="phone"
							value="${user.userPhoneNo }">
					</div>
					<div id="date">
						<span>가입일</span> <input type="datetime" id="date" name="date"
							value="${user.userDate }" readonly>
					</div>
					<div id="submit">
						<button type="submit">수정하기</button>
					</div>
					<c:if test="${sessionScope.id ne 'admin'}">
						<div id="action">
							<div id="bye">
								<a href="javascript:void(0)"><p onclick="check()">회원탈퇴</p></a>
							</div>
						</div>
					</c:if>
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
			var url = "/img/kakaoQR.JPG";
			var name = "popup";
			var options = "width = 500, height = 500";
			window.open(url, name, options);
		}
		function check() {
			if (confirm("주의! 회원탈퇴 이후에는 복구 할 수 없습니다. \n정말로 회원탈퇴를 진행하시겠습니까?")) {
				location.href = "/register/delete?id=${sessionScope.id }";
			}
		}
	</script>
</body>

</html>