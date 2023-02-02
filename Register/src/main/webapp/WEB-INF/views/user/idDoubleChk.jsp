<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
<link rel="stylesheet" href="/resources/userCss/idDoubleChk.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap"
	rel="stylesheet">

</head>

<body>
	<main>
		<form action="/register/idChk" method="get" name="idCheckForm">
			<h1>아이디 중복 확인</h1>
			<div id="inputBox">
				<input type="text" name="id" value="${id}"> <input
					type="submit" value="중복 체크">
				<c:choose>
					<c:when test="${result==1}">
						<h3>${id}는 이미 사용 중인 아이디입니다.</h3>
					</c:when>
					<c:when test="${result==0}">
						<h3>${id}는 사용가능한 아이디입니다.</h3>
						<input type="button" value="사용" class="choice" onclick="idOk()">
					</c:when>
					<c:otherwise>
						<h3>오류 발생 result:${result}</h3>
					</c:otherwise>
				</c:choose>
				<input type="button" onclick="window.close()" class="choice" value="취소" /><br>
			</div>
		</form>
	</main>
	<script>
		function idOk() {
			opener.joinform.viewId.value = document.idCheckForm.id.value;
			opener.joinform.chkUserId.value = document.idCheckForm.id.value;

			self.close();
		}
	</script>
</body>

</html>