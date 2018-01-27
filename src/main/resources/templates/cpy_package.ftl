<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/img/favicon.ico" rel="shortcut icon">
    <title>美盒优品-公司后台</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/css/cpy_package.css" />
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
                    <li class="hd_check"><a href="javascript:;">套餐管理</a></li>
                </ul>
            </div>
            <div class="orders-body">
                <!--套餐管理信息-->
                <div id="cpy-package">
                    <ul>
                    <#list unauditGoods as good>
                        <li class="goodlist">
                            <div class="content">
                                <div class="title-box">
                                    <div class="img-bg">
                                        <img src="/img/company/pack-list-bg.png" alt="" />
                                    </div>
                                    <div class="title-info">
                                        <input class="goodId" id="goodId" type="hidden" value="${good.id?c}"/>
                                        <input class="goodId" id="goodId" type="hidden" value="${good.pictureUrl}"/>
                                        <span class="title">杭州佳妮万科安仁蛋糕店</span>
                                        <span class="times">${good.createTime?string('yyyy-MM-dd')}</span>
                                    </div>
                                </div>
                                <div class="pack-box">
                                    <div class="img-pack">
                                        <img src="${good.primaryPictureUrl}" alt="" />
                                    </div>
                                    <div class="pack-info">
                                        <span class="info-title">${good.name}</span>
                                        <span class="info-text">此套餐包含的商品有<strong>${good.amount}</strong>个</span>
                                        <span class="info-number">￥<strong class="price">${good.price}</strong></span>
                                        <span class="info-check">管理套餐信息+</span>
                                    </div>
                                </div>
                            </div>
                            <#include "my_pack_dev.ftl"/>
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
<#--<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>-->
<#--<script type="text/javascript" src="/js/pack.js"></script>-->
</body>
</html>
