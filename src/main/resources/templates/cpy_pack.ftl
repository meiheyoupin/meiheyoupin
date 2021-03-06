<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/img/favicon.ico" rel="shortcut icon">
    <title>美盒优品-公司后台</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/css/cpy_pack.css" />
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
                    <li class="hd_check"><a href="javascript:;">套餐审核</a></li>
                </ul>
            </div>
            <div class="orders-body">
                <!--套餐审核信息-->
                <div id="cpy-pack">
                    <ul>
                        <#list unauditGoods as good>
                        <li class="goodlist">
                            <div class="content">
                                <div class="title-box">
                                    <div class="img-bg">
                                        <img src="/img/company/pack-list-bg.png" alt="" />
                                    </div>
                                    <div class="title-info">
                                        <input class="goodId" id="goodId" type="hidden" value="${good.good.id?c}"/>
                                        <input class="goodPictureUrl" id="goodPictureUrl" type="hidden" value="${good.good.pictureUrl}"/>
                                        <span class="title">${good.store.name}</span>
                                        <span class="times">${good.good.createTime?string('yyyy-MM-dd')}</span>
                                    </div>
                                </div>
                                <div class="pack-box">
                                    <div class="img-pack">
                                        <img src="${good.good.primaryPictureUrl}" alt="" />
                                    </div>
                                    <div class="pack-info">
                                        <span class="info-title">${good.good.name}</span>
                                        <span class="info-text">此套餐包含的商品有<strong>${good.good.amount}</strong>个</span>
                                        <span class="info-number">￥<strong class="price">${good.good.price}</strong></span>
                                        <span class="info-check">审核套餐信息+</span>
                                    </div>
                                </div>
                            </div>
                            <#include "my_pack_dev.ftl"/>
                            <#include "my_pack_egis.ftl"/>
                        </li>
                        </#list>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<!--footer-->
<#include "cpy_footer.ftl"/>
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/js/pack.js"></script>
</body>
</html>
