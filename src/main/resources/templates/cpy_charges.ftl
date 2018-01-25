<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/img/favicon.ico" rel="shortcut icon">
    <title>美盒优品-公司后台</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/css/cpy_charges.css" />
</head>
<body>
<!--header-->
<#include "cpy_header.html"/>
<!--页面开始-->
<div id="main">
    <div class="container">
        <#include "order-nav.ftl"/>
        <div class="orders">
            <div class="orders-head">
                <ul>
                    <li class="hd_check"><a href="javascript:;">提现管理</a></li>
                </ul>
            </div>
            <div class="orders-body">
                <!--提现管理-->
                <ul id="cpy_charges">
                    <li>
                        <div class="title">
                            <div class="img-box">
                                <img src="/img/charges-list-bg.png" alt="">
                            </div>
                            <div class="title-info">
                                <span class="store-title">看酸辣粉蛋糕店</span>
                                <span class="store-times">2018-1-18-10:12</span>
                            </div>
                        </div>
                        <div class="draw-box">
                            <p class="draw-pri">申请提现: <span>￥<strong class="price">123</strong></span></p>
                            <div class="draw-info">
                                <span class="name">唐马儒 <strong>先生</strong></span>
                                <span class="phone">13854651231</span>
                                <button class="pass">通过</button>
                                <button class="not">驳回</button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!--footer-->
<#include "cpy_footer.ftl"/>
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/js/custom.js"></script>
</body>
</html>
