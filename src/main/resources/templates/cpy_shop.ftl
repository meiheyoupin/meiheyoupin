<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="img/favicon.ico" rel="shortcut icon">
    <title>美盒优品-公司后台</title>
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/cpy_shop.css" />
</head>
<body>
<!--头部logo部分-->
<div id="header">
    <div class="container">
        <h1 class="logo">
            <a href="index.html" title="美盒优品"></a>
        </h1>
        <span class="company-title">公司后台</span>
    </div>
</div>
<!--页面开始-->
<div id="main">
    <div class="container">
    <#include "order-nav.ftl"/>
        <div class="orders">
            <div class="orders-head">
                <ul>
                    <li class="hd_check"><a href="javascript:;">商品审核</a></li>
                </ul>
            </div>
            <div class="orders-body">
                <!--商品审核信息-->
                <div id="cpy-shop">
                    <div class="menu">
                        <a href="#">综合排序</a><a href="#">价格优先</a><a href="#">销量优先</a><a href="#">好评优先</a>
                    </div>
                    <ul>
                        <li>
                            <div class="content">
                                <div class="title-box">
                                    <div class="img-bg">
                                        <img src="img/company/shop-list-bg.png" alt="" />
                                    </div>
                                    <div class="title-info">
                                        <span class="title">杭州佳妮万科安仁蛋糕店</span>
                                        <span class="times">12-12-10:52</span>
                                    </div>
                                </div>
                                <div class="shop-box">
                                    <div class="img-shop">
                                        <img src="img/company/shop-list-img.jpg" alt="" />
                                    </div>
                                    <div class="shop-info">
                                        <span class="info-title">薄荷夏日可乐</span>
                                        <span class="info-text">清新水果黄桃味</span>
                                        <span class="info-number">￥<strong class="price">3.5</strong></span>
                                        <span class="info-check">审核商品信息+</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="content">
                                <div class="title-box">
                                    <div class="img-bg">
                                        <img src="img/company/shop-list-bg.png" alt="" />
                                    </div>
                                    <div class="title-info">
                                        <span class="title">杭州佳妮万科安仁蛋糕店</span>
                                        <span class="times">12-12-10:52</span>
                                    </div>
                                </div>
                                <div class="shop-box">
                                    <div class="img-shop">
                                        <img src="img/company/shop-list-img.jpg" alt="" />
                                    </div>
                                    <div class="shop-info">
                                        <span class="info-title">薄荷夏日可乐</span>
                                        <span class="info-text">清新水果黄桃味</span>
                                        <span class="info-number">￥<strong class="price">3.5</strong></span>
                                        <span class="info-check">审核商品信息+</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="content">
                                <div class="title-box">
                                    <div class="img-bg">
                                        <img src="img/company/shop-list-bg.png" alt="" />
                                    </div>
                                    <div class="title-info">
                                        <span class="title">杭州佳妮万科安仁蛋糕店</span>
                                        <span class="times">12-12-10:52</span>
                                    </div>
                                </div>
                                <div class="shop-box">
                                    <div class="img-shop">
                                        <img src="img/company/shop-list-img.jpg" alt="" />
                                    </div>
                                    <div class="shop-info">
                                        <span class="info-title">薄荷夏日可乐</span>
                                        <span class="info-text">清新水果黄桃味</span>
                                        <span class="info-number">￥<strong class="price">3.5</strong></span>
                                        <span class="info-check">审核商品信息+</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="content">
                                <div class="title-box">
                                    <div class="img-bg">
                                        <img src="img/company/shop-list-bg.png" alt="" />
                                    </div>
                                    <div class="title-info">
                                        <span class="title">杭州佳妮万科安仁蛋糕店</span>
                                        <span class="times">12-12-10:52</span>
                                    </div>
                                </div>
                                <div class="shop-box">
                                    <div class="img-shop">
                                        <img src="img/company/shop-list-img.jpg" alt="" />
                                    </div>
                                    <div class="shop-info">
                                        <span class="info-title">薄荷夏日可乐</span>
                                        <span class="info-text">清新水果黄桃味</span>
                                        <span class="info-number">￥<strong class="price">3.5</strong></span>
                                        <span class="info-check">审核商品信息+</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!--审核商品信息弹框-->
<div id="shop" class="black_overlay"></div>
<div id="MyShop" class="white_content">
    <div class="check_add">
        <div class="cont-box">
            <span class="onClose">×</span>
            <h2>审核商品信息</h2>
            <div class="cont_lf">
                <p class="shop-lf-title">
                    <span>激爽夏日可乐</span>
                </p>
                <p class="shop-lf-img">
                    <img src="img/check_m2987084839.jpg" alt="" />
                </p>
                <p class="shop-lf-depict">
                    <textarea readonly="readonly" placeholder="描述一下你的商品...">可乐聚会，激爽夏日，给这个热不可挡的夏日带来最酷的体验</textarea>
                </p>
            </div>
            <div class="cont_rt">
                <p class="shop-rt-price">
                    单价:<span>￥</span><strong>3.5</strong>
                </p>
                <p class="shop-rt-img">
                    <img src="img/check_bg.jpg" alt="" />
                </p>
            </div>
        </div>
        <div class="btn-box">
            <div class="btn">
                <button class="pass" type="button">审核通过</button>
                <button class="not" type="button">审核未通过</button>
            </div>
        </div>
    </div>
</div>
<!--审核通过弹框-->
<div id="pass" class="black_overlay"></div>
<div id="MyPass" class="white_content">
    <div class="move">
        <div class="title">
            <img src="img/complete.png" alt="" />
        </div>
    </div>
    <div class="list">
        <p>已通过!</p>
        <p>稍后将自动发送信息到商家...</p>
    </div>
    <a class="back" href="javascript:;">×</a>
</div>
<!--审核未通过弹框-->
<div id="not" class="black_overlay"></div>
<div id="MyNot" class="white_content">
    <div class="move">
        <div class="title">
            <span>填写原因</span>
        </div>
    </div>
    <div class="list">
        <ul>
            <li><input type="checkbox" checked="checked"/>商品名违规</li>
            <li><input type="checkbox"/>价格不合理</li>
            <li><input type="checkbox"/>口味描述不正确</li>
            <li><input type="checkbox"/>商品介绍违规</li>
            <li class="last-item">
                <input type="checkbox"/>
                <span>其他</span><textarea class="other"></textarea>
            </li>
        </ul>
        <div class="btn-send"><a href="">发送</a></div>
        <div class="btn-back"><a href="javascript:;">返回</a></div>
    </div>
</div>
<!--页脚-->
<footer>
    <div>客服电话：<span>0571-86438349</span>（每天9:00 - 22:00）</div>
    <div>Copyright © 2017, meiheyoupin.com. All rights reserved | 浙ICP备16043943号-1 </div>
</footer>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
    //商品审核弹框
    $(".info-check").click(function(){
        $("#shop").show();
        $("#MyShop").show();
    });
    $(".onClose").click(function(){
        $("#shop").hide();
        $("#MyShop").hide();
    });
    //审核通过弹框
    $(".pass").click(function(){
        $("#pass").show();
        $("#MyPass").show();
    })
    $(".back").click(function(){
        $("#pass").hide();
        $("#MyPass").hide();
    })
    //审核未通过弹框
    $(".not").click(function(){
        $("#not").show();
        $("#MyNot").show();
    });
    $(".btn-back, .btn-send").click(function(){
        $("#not").hide();
        $("#MyNot").hide();
    });
</script>
</body>
</html>
