<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/img/favicon.ico" rel="shortcut icon">
    <title>美盒优品-登录</title>
    <link rel="stylesheet" type="text/css" href="./css/common.css"/>
    <link rel="stylesheet" type="text/css" href="./css/login.css"/>
</head>
<body>
<!--页头-->
<div id="header">
    <div class="container">
        <h1 class="logo">
            <a href="/" title="美盒优品"></a>
        </h1>
        <div class="logo-text">公司版</div>
    </div>
</div>
<!--登录框-->
<div class="body">
    <div class="wrapper">
        <div class="login-img">
            <img src="img/login_pic.png" alt=""/>
        </div>
        <form id="loginForm">
            <h2>登录美盒优品</h2>
            <div class="hidden">
                <div id="error" style="display: none;">账号和密码不匹配，请重新输入!</div>
            </div>
            <p class="login-user">
                <i class="icon"></i>
                <input id="loginInputName" type="text" name="adminName" maxlength="11" placeholder="账号"/>
            </p>
            <p class="login-password">
                <input id="loginInputPassword" type="password" name="adminPassword" maxlength="16" placeholder="密码"/>
            </p>
            <p class="login-submit">
                <input id="loginButton" type="button" value="登录"/>
            </p>
            <p class="login-info">
                <a href="/forget.html">忘记密码 </a>
            </p>
        </form>
    </div>
</div>
<!--页脚-->
<footer>
    <div>客服电话：<span>4006-888-887</span>（每天9:00 - 22:00）</div>
    <div>Copyright © 2017, meiheyoupin.com. All rights reserved | 浙ICP备16043943号-1</div>
</footer>
<!--js-->
<div id='cover'></div>
<div id='tishi' style="display: none;">
    <p><i class="iconfont"></i>登录成功!</p>
    <div><span id='num'>5</span>秒后自动跳转至首页</div>
</div>

<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/login.js"></script>

</body>
</html>
