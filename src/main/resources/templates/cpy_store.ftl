<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/img/favicon.ico" rel="shortcut icon">
    <title>美盒优品-公司后台</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/css/cpy_store.css" />
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
                    <li class="hd_check"><a href="javascript:;">店铺审核</a></li>
                </ul>
            </div>
            <div class="orders-body">
                <!--店铺信息-->
                <ul id="cpy-store">
                    <#list unauditStores as store>
                        <li>
                            <div class="user-info">
                                <div class="info-lf">
                                    <div class="title">
                                        <div class="img-box">
                                            <img src="/img/company/user-list-bg.png" alt="" />
                                        </div>
                                        <div class="title-info">
                                            <input class="storeId" id="storeId" type="hidden" value="${store.id}"/>
                                            <span class="title-box">${store.storeName}</span>
                                            <span class="times-box">${store.createTime?string('yyyy-MM-dd')}</span>
                                            <span class="num-box">${store.invitationCode}</span>
                                        </div>
                                    </div>
                                    <div class="check-shop">
                                        <span class="ck-shop">审核店家信息+</span>
                                    </div>
                                </div>
                                <div class="info-rt">
                                    <div class="phone">${store.tel}</div>
                                    <div class="name">
                                        <span>${store.bossName}</span>
                                        <span class="sex">先生</span>
                                    </div>
                                </div>
                            </div>
                            <div id="store">
                                <div class="shop-name">
                                    <p class="title-shop">店铺名称</p>
                                    <p class="name-box">
                                        <span class="name1">${store.storeName}</span>
                                        <span class="name2"> 账号: </span>
                                        <span class="name3">${store.tel}</span>
                                    </p>
                                </div>
                                <div class="shop-addr">
                                    <p class="title-shop">店铺地址</p>
                                    <p class="addr-box">
                                        <span class="addr1">${store.storeAddr}</span>
                                    </p>
                                </div>
                                <div class="shop-env">
                                    <p class="title-shop">店铺环境</p>
                                    <p class="env-shop">
                                        <img class="file-bg" src="${store.storeOutsidePhotoUrl}" alt="" />
                                        <img class="file-bg" src="${store.storeInsidePhotoUrl}" alt="" />
                                    </p>
                                </div>
                                <div class="shop-id">
                                    <p class="title-shop">法人身份证</p>
                                    <p class="id-shop">
                                        <img class="file-bg" src="${store.bossIdcardPhotoUrl}" alt="" />
                                        <img class="file-bg" src="${store.bossIdcardPhotoUrl}" alt="" />
                                    </p>
                                    <span>正面</span>
                                    <span>背面</span>
                                </div>
                                <div class="shop-license">
                                    <p class="title-shop">营业执照</p>
                                    <p class="license-shop">
                                        <img class="file-bg" src="${store.certificatePhotoUrl}" alt="" />
                                    </p>
                                </div>
                                <div class="shop-licence">
                                    <p class="title-shop">卫生许可证</p>
                                    <p class="licence-shop">
                                        <img class="file-bg" src="${store.storeLicencePhotoUrl}" alt="" />
                                    </p>
                                </div>
                                <div class="examine">
                                    <p>
                                        <button class="pass" type="button" onclick="auditStore()">审核通过</button>
                                        <button class="not" type="button">审核未通过</button>
                                    </p>
                                </div>
                                <span class="close">×</span>
                            </div>
                        </li>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
</div>
<!--审核通过弹框-->
<div id="pass" class="black_overlay"></div>
<div id="MyPass" class="white_content">
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
<div id="not" class="black_overlay"></div>
<div id="MyNot" class="white_content">
    <div class="move">
        <div class="title">
            <span>填写原因</span>
        </div>
    </div>
    <div class="list">
        <ul>
            <li><input name="reason" type="checkbox" value="店铺环境照片不符"/>店铺环境照片不符</li>
            <li><input name="reason" type="checkbox" value="店铺环境照片模糊"/>店铺环境照片模糊</li>
            <li><input name="reason" type="checkbox" value="身份证照片身份不符"/>身份证照片身份不符</li>
            <li><input name="reason" type="checkbox" value="身份证照片模糊"/>身份证照片模糊</li>
            <li><input name="reason" type="checkbox" value="身份证照片模糊、不符"/>身份证照片模糊、不符</li>
            <li><input name="reason" type="checkbox" value="卫生证照片模糊"/>卫生证照片模糊</li>
            <li><input name="reason" type="checkbox" value="营业执照照片过期"/>营业执照照片过期、不符</li>
            <li><input name="reason" type="checkbox" value="营业执照照片模糊"/>营业执照照片模糊</li>
            <li class="last-item">
                <input type="checkbox"/>
                <span>其他</span><textarea name="reason" class="other"></textarea>
            </li>
        </ul>
        <div class="btn-send"><a href="javascript:;" onclick="unsanctionedStore()">发送</a></div>
        <div class="btn-back"><a href="javascript:;">返回</a></div>
    </div>
</div>
<!--footer-->
<#include "cpy_footer.ftl"/>
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/js/store.js"></script>
</body>
</html>
