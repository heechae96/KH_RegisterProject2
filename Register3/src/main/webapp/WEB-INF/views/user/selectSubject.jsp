<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>개설 과목 조회</title>
<link rel="stylesheet" href="/resources/userCss/userSelectSubject.css">
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
			<h1>수강 신청</h1>
			<form action="/user/selectSubject" method="post">
				<input type="hidden" name="userId" value="${sessionScope.user.userId }">
				<input type="hidden" name="subjectCode">
				<div id="tableBox">
					<table>
						<tr>
							<th>과목명</th>
							<th>과목코드</th>
							<th>교수명</th>
							<th>신청 인원</th>
							<th>인원 제한</th>
							<th>개강일</th>
							<th>종강일</th>
							<th>신청</th>
						</tr>
						<c:forEach var="subject" items="${list }">
							<tr>
								<td>${subject.subjectName }</td>
								<td>${subject.subjectCode }</td>
								<td>${subject.name }</td>
								<td>${subject.enrollNo }</td>
								<td>${subject.maxNo }</td>
								<td>${subject.startDate }</td>
								<td>${subject.endDate }</td>
								<td>
									<button id="${subject.subjectCode }" onclick="selChk(this)">
										선택</button>
								</td>
							</tr>
						</c:forEach>
					</table>
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
		function selChk(event) {
			let code = event.getAttribute('id');
			let hiddenCode = document.querySelector("[name=subjectCode]");
			hiddenCode.setAttribute("value", code);
		}
	</script>
</body>

</html>