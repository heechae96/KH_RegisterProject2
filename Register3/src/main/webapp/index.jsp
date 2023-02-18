<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script defer src="./js/youtube.js"></script>
<meta charset="UTF-8">
<title>Welcome to my website</title>
<link rel="stylesheet" href="/resources/commonCss/index.css">
</head>
<body>
	<div id="indexBtn" class="center">
		<button id="visual-btn" onclick="location.href='/home'">
			Go to Register
		</button>
	</div>

	<div class="video-film">
		<div class="video-background">
			<div id="muteYouTubeVideoPlayer"></div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script async src="https://www.youtube.com/iframe_api"></script>
	<script type="text/javascript">
		var player;

		function onYouTubePlayerAPIReady() {
			player = new YT.Player('muteYouTubeVideoPlayer', {
				playerVars : {
					autoplay : 1,
					mute : 1,
					loop: 1,
					controls : 0,
					playlist : 'IsS2z5L0Bvg'
				}
			});
		}
	</script>
</body>
</html>