<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인페이지</title>
    <link rel="stylesheet" href="/resources/userCss/main.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap" rel="stylesheet">
</head>
<body>
    <div id="container">
        <header>
            <div id="user">
                <a href="/user/login.html">
                    <img src="/resources/img/login.png" alt="로그인">
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
            <div id="kakao">
                <img src="/resources/img/kakao.png" alt="카카오">
                <p onclick="popup();">Add to KakaoTalk</p>
            </div>
            <div id="git">
                <img src="/resources/img/git.png" alt="깃헙">
                <a href="https://github.com/heechae96" target="_blank">
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
    </script>
</body>
</html>