<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/img/favicon.ico" rel="shortcut icon">
    <title>美盒优品-公司后台</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/css/cpy_custom.css" />
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
                    <li class="hd_check"><a href="javascript:;">定制订单</a></li>
                </ul>
            </div>
            <div class="orders-body">
                <!--企业定制-->
                <ul id="cpy_custom">
                    <li>
                        <div class="img-box">
                            <img src="/img/custom_bg.png" alt="" />
                        </div>
                        <div class="content">
                            <div class="info-box">
                                <p class="title">企业定制我想要的效果啊啊啊啊</p>
                                <p class="budget">预算:&nbsp;￥<strong>200</strong></p>
                                <p class="people-num">人数:&nbsp;<strong>10</strong>人</p>
                                <p class="time">11-11 11:11</p>
                                <b class="spread"></b>
                            </div>
                            <div class="end">
                                <div class="state">
                                    <a class="a-end" href="javascript:;">查看订单</a>
                                </div>
                                <div class="price">
                                    <a href="#">￥500</a>
                                </div>
                                <div class="btn-again">
                                    <a href="payments.html">现在付款</a>
                                </div>
                            </div>
                        </div>
                        <div class="custom-info">
                            <div class="box-info">
                                <div class="text">
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nihil ea nisi perferendis beatae voluptatibus numquam hic blanditiis ut deserunt corporis autem eligendi voluptas harum! Distinctio commodi ducimus iste praesentium vitae.
                                </div>
                            </div>
                            <div class="info-rt">
                                <div class="name">
                                    唐马儒
                                    <div class="sex">先生</div>
                                    <p class="phone">13834523569</p>
                                </div>
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
