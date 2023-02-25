<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>이용자 조회</title>
<link rel="stylesheet" href="/resources/adminCss/selectUser.css">
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
			<h1>이용자 조회</h1>
			<div id="tableBox">
				<table>
					<tr>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>이름</th>
						<th>과목 코드</th>
						<th>과목명</th>
						<th>휴대번호</th>
						<th>가입일</th>
						<th>삭제</th>
					</tr>
					<c:forEach var="user" items="${list }">
						<tr>
							<td>${user.userId }</td>
							<td>${user.userPw }</td>
							<td>${user.userName }</td>
							<c:choose>
								<c:when test="${user.subjectCode == 0}">
									<td>-</td>
								</c:when>
								<c:otherwise>
									<td>${user.subjectCode }</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${user.subjectCode == ''}">
									<td>-</td>
								</c:when>
								<c:otherwise>
									<td>${user.subjectName }</td>
								</c:otherwise>
							</c:choose>
							<td>${user.userPhoneNo }</td>
							<td><fmt:formatDate value="${user.userDate }"
									pattern="yyyy-MM-dd" /></td>
							<td>
								<button class="${user.userId }" onclick="delChk(this)">선택</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</main>
		<footer>
			<div>
				<img src="/resources/img/kakao.png" alt="카카오">
				<p onclick="popup();">Add to KakaoTalk</p>
			</div>
			<div>
				<img src="/resources/img/git.png" alt="깃헙"> <a
					href="https://github.com/heechae96/KH_RegisterProject2"
					target="_blank">
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
		function delChk(event) {
			let delConfirm = confirm('해당 이용자를 정말 삭제하시겠습니까?');
			var id = event.getAttribute('class');
			if (delConfirm) {
				location.href = "/admin/deleteUser?id=" + id;
			} else {
				return;
			}
		}
	</script>
</body>

</html>