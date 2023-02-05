<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>과목 수정</title>
<link rel="stylesheet" href="/resources/adminCss/modify.css">
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
			<h1>과목 수정</h1>
			<form action="/admin/update" method="post">
				<div id="inputBox">
					<div id="subjectName">
						<span>과목명</span> <input type="text" name="subjectName"
							value="${subject.subjectName }" required>
					</div>
					<div id="subCode">
						<span>과목코드</span> <input type="text" name="subCode"
							value="${subject.subjectCode }" readonly>
					</div>
					<div id="name">
						<span>교수명</span> <input type="text" name="name"
							value="${subject.name }" required>
					</div>
					<div id=enrollNum">
						<span>신청 인원</span> <input type="number" name="enrollNum"
							value="${subject.enrollNo }" readonly>
					</div>
					<div id="maxNum">
						<span>인원 제한</span> <input type="number" name="maxNum"
							value="${subject.maxNo }" required>
					</div>
					<div id="start">
						<span>개강일</span> <input type="date" name="start"
							value="${subject.startDate }" required>
					</div>
					<div id="end">
						<span>종강일</span> <input type="date" name="end"
							value="${subject.endDate }" required>
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