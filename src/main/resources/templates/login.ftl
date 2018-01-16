<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/img/favicon.ico" rel="shortcut icon">
    <title>美盒优品-登录</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/css/login.css"/>
</head>
<body>
<!--header-->
<#include "cpy_header.html"/>
<!--登录框-->
<div class="body">
    <div class="wrapper">
        <div class="login-img">
            <img src="/img/login-bg.png" alt=""/>
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
        </form>
    </div>
</div>
<!--footer-->
<#include "cpy_footer.ftl"/>
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
