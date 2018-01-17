<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/img/favicon.ico" rel="shortcut icon">
    <title>美盒优品-公司后台</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/css/cpy_shop.css" />
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
                    <li class="hd_check"><a href="javascript:;">商品审核</a></li>
                </ul>
            </div>
            <div class="orders-body">
                <!--商品审核信息-->
                <div id="cpy-shop">
                    <ul>
                        <#list unauditGoods as good>
                        <li class="shoplist">
                            <div class="content">
                                <div class="title-box">
                                    <div class="img-bg">
                                        <img src="/img/company/shop-list-bg.png" alt="" />
                                    </div>
                                    <div class="title-info">
                                        <input class="goodId" id="goodId" type="hidden" value="${good.id}"/>
                                        <span class="title">杭州佳妮万科安仁蛋糕店</span>
                                        <span class="times">${good.createTime?string('yyyy-MM-dd')}</span>
                                    </div>
                                </div>
                                <div class="shop-box">
                                    <div class="img-shop">
                                        <img src="/img/company/shop-list-img.jpg" alt="" />
                                    </div>
                                    <div class="shop-info">
                                        <span class="info-title">${good.name}</span>
                                        <span class="info-text">${good.content}</span>
                                        <span class="info-number">￥<strong class="price">${good.price}</strong></span>
                                        <span class="info-check">审核商品信息+</span>
                                    </div>
                                </div>
                            </div>
                            <#include "myShop_dev.ftl">
                        </li>
                        </#list>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!--审核通过弹框-->
<div id="pass"></div>
<div id="MyPass">
    <div class="move">
        <div class="title">
            <img src="/img/complete.png" alt="" />
        </div>
    </div>
    <div class="list">
        <p>已通过!</p>
        <p>稍后将自动发送信息到商家...</p>
    </div>
    <a class="back" href="javascript:;">×</a>
</div>
<!--审核未通过弹框-->
<div id="not"></div>
<div id="MyNot">
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
<!--footer-->
<#include "cpy_footer.ftl"/>
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/shop.js"></script>
</body>
</html>
