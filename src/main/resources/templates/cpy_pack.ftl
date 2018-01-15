<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="img/favicon.ico" rel="shortcut icon">
    <title>美盒优品-公司后台</title>
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/cpy_pack.css" />
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
                    <li class="hd_check"><a href="javascript:;">套餐审核</a></li>
                </ul>
            </div>
            <div class="orders-body">
                <!--套餐审核信息-->
                <div id="cpy-pack">
                    <ul>
                        <#list unauditGoods as good>
                        <li>
                            <div class="content">
                                <div class="title-box">
                                    <div class="img-bg">
                                        <img src="img/company/pack-list-bg.png" alt="" />
                                    </div>
                                    <div class="title-info">
                                        <input class="goodId" id="goodId" type="hidden" value="${good.id}"/>
                                        <span class="title">杭州佳妮万科安仁蛋糕店</span>
                                        <span class="times">${good.createTime?string('yyyy-MM-dd')}</span>
                                    </div>
                                </div>
                                <div class="pack-box">
                                    <div class="img-pack">
                                        <img src="img/company/pack-list-img.jpg" alt="" />
                                    </div>
                                    <div class="pack-info">
                                        <span class="info-title">${good.name}</span>
                                        <span class="info-text">此套餐包含的商品有<strong>${good.amount}</strong>个</span>
                                        <span class="info-number">￥<strong class="price">${good.price}</strong></span>
                                        <span class="info-check">审核套餐信息+</span>
                                        <#include "myPack_dev.ftl"/>
                                    </div>
                                </div>
                            </div>
                        </li>
                        </#list>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!--审核商品信息弹框-->
<div id="pack" class="black_overlay"></div>

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
            <li><input name="reason" type="checkbox" checked="checked" value="套餐名违规"/>套餐名违规</li>
            <li><input name="reason" type="checkbox" value="价格不合理"/>价格不合理</li>
            <li><input name="reason" type="checkbox" value="套餐搭配不完善"/>套餐搭配不完善</li>
            <li><input name="reason" type="checkbox" value="套餐描述违规"/>套餐描述违规</li>
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
    //套餐审核弹框
    $(".info-check").click(function(){
        $("#pack").show();
        $("#MyPack").show();
    });
    $(".onClose").click(function(){
        $("#pack").hide();
        $("#MyPack").hide();
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
