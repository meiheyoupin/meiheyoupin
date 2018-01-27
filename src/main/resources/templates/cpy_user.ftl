<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/img/favicon.ico" rel="shortcut icon">
    <title>美盒优品-公司后台</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/css/cpy_user.css" />
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
                    <li class="hd_check"><a href="javascript:;">用户信息</a></li>
                </ul>
            </div>
            <div class="orders-body">
                <!--用户信息-->
                <ul id="cpy-user">
                    <li>
                        <div class="user-info">
                            <div class="info-lf">
                                <div class="title">
                                    <div class="img-box">
                                        <img src="/img/company/user-list-bg.png" alt="" />
                                    </div>
                                    <div class="title-info">
                                        <span class="title-box">杭州佳妮万科安仁药业有限公司</span>
                                        <span class="times-box">12-14-10:52</span>
                                        <span class="num-box">351254</span>
                                    </div>
                                </div>
                                <div class="addr">
                                    <span class="default">默认</span>
                                    <span class="address">相符街道安利大道24号万科大厦2楼安仁有限公司</span>
                                    <span class="spread"></span>
                                </div>
                            </div>
                            <div class="info-rt">
                                <div class="phone">13846245915</div>
                                <div class="name">
                                    <span>唐马儒</span>
                                    <div class="sex">先生</div>
                                </div>
                                <div class="job">策划部</div>
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

<#--<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>-->
<#--<script type="text/javascript" src="/js/common.js"></script>-->
<#--<script>-->
    <#--<#if userName??>-->
    <#--localStorage.setItem("username", "${userName}");-->
    <#--</#if>-->
<#--</script>-->
</body>
</html>
