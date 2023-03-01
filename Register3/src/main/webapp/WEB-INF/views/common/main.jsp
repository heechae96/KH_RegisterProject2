<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<!-- favicon.ico 404 오류 방지 -->
<link rel="shortcut icon" href="#">
<link rel="stylesheet" href="/resources/commonCss/main.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap"
	rel="stylesheet">
</head>
<body>
	<!-- main : 로그인을 하지 않은 경우 -->
	<c:if test="${sessionScope.user eq null }">
		<div id="container">
			<header>
				<div id="user">
					<a href="/user/login"> <img src="/resources/img/login.png"
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
	</c:if>

	<!-- mainLogin : 로그인을 한 경우 -->
	<c:if test="${sessionScope.user ne null }">
		<!-- 관리자인 경우 -->
		<c:if test="${sessionScope.user.userId eq 'admin' }">
			<div id="container">
				<header>
					<nav>
						<div id="insert">
							<img src="/resources/img/add.png" alt="insert"> <a
								href="/subject/insert">과목 추가</a>
						</div>
						<div id="select1">
							<img src="/resources/img/checked.png" alt="chechk & modify">
							<a href="/subject/select">개설 과목 조회</a>
						</div>
						<div id="select2">
							<img src="/resources/img/user.png" alt="chechk & modify"> <a
								href="/user/select">이용자 조회</a>
						</div>
						<div id="logout">
							<img src="/resources/img/logout.png" alt="logout"> <a
								href="/user/logout" onclick="return logout()">로그아웃</a>
						</div>
						<div id="update">
							<img src="/resources/img/admin.png" alt="정보변경"> <a
								href="/user/update">관리자님</a>
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
		</c:if>
		
		<!-- 이용자인 경우 -->
		<c:if test="${sessionScope.user.userId ne 'admin' }">
			<div id="container">
				<header>
					<nav>
						<div id="add">
							<img src="/resources/img/add.png" alt="add"> <a
								href="/user/selectSubject">수강 신청</a>
						</div>
						<div id="check">
							<img src="/resources/img/checked.png" alt="chechk & modify">
							<a href="/user/updateSubject">확인 / 정정</a>
						</div>
						<div id="logout">
							<img src="/resources/img/logout.png" alt="logout"> <a
								href="/user/logout" onclick="return logout()">로그아웃</a>
						</div>
						<div id="modify">
							<img src="/resources/img/user.png" alt="마이페이지"> <a
								href="/user/update">${sessionScope.user.userId }</a>
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
		</c:if>
	</c:if>
	<script>
		function popup() {
			var url = "/resources/img/kakaoQR.JPG";
			var name = "popup";
			var options = "width = 750, height = 925";
			window.open(url, name, options);
		}
		function logout() {
			if(confirm("정말 로그아웃 하시겠습니까?")){
				return true;
			}else{
				return false;
			}
		}
	</script>
</body>
</html>