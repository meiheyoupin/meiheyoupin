<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="img/favicon.ico" rel="shortcut icon">
    <title>美盒优品-公司后台</title>
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/cpy_person.css" />
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
                    <li class="hd_check"><a href="javascript:;">人员信息</a></li>
                </ul>
            </div>
            <div class="orders-body">
                <!--人员信息-->
                <div id="cpy-person">
                    <table border="0" cellspacing="0" cellpadding="0">
                        <tr><th>姓名</th><th>性别</th><th>手机号</th><th>邀请码</th><th>登记日期</th></tr>
                        <tr>
                            <td>唐马儒</td>
                            <td>男士</td>
                            <td>138-4466-7788</td>
                            <td>335461</td>
                            <td>2018/12/12</td>
                            <td>编辑</td>
                        </tr>
                        <tr>
                            <td>唐马儒</td>
                            <td>男士</td>
                            <td>138-4466-7788</td>
                            <td>335461</td>
                            <td>2018/12/12</td>
                            <td>编辑</td>
                        </tr>
                        <tr>
                            <td>唐马儒</td>
                            <td>男士</td>
                            <td>138-4466-7788</td>
                            <td>335461</td>
                            <td>2018/12/12</td>
                            <td>编辑</td>
                        </tr>
                        <tr>
                            <td>唐马儒</td>
                            <td>男士</td>
                            <td>138-4466-7788</td>
                            <td>335461</td>
                            <td>2018/12/12</td>
                            <td>编辑</td>
                        </tr>
                        <tr>
                            <td>唐马儒</td>
                            <td>男士</td>
                            <td>138-4466-7788</td>
                            <td>335461</td>
                            <td>2018/12/12</td>
                            <td>编辑</td>
                        </tr>
                    </table>
                    <table class="add_up" border="0" cellspacing="0" cellpadding="0" style="display: none;">
                        <tr>
                            <th>姓名</th><th>性别</th><th>手机号</th><th>邀请码</th><th>登记日期</th>
                        </tr>
                        <tr>
                            <td><input type="text" style="width: 80px;" /></td>
                            <td>
                                <select name="">
                                    <option value="">男士</option>
                                    <option value="">女士</option>
                                </select>
                            </td>
                            <td><input type="text"  style="width: 160px;" /></td>
                            <td><input type="text"  style="width: 110px;" /></td>
                            <td><input type="text"  style="width: 140px;" /></td>
                            <td style="color: #FED500;">确认</td>
                        </tr>
                    </table>
                    <div class="spread">
                        <span class="add">增加员工信息+</span>
                        <span class="btn_up"><img src="img/cut.png" alt="" /></span>
                        <span class="cut">收起员工信息</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--footer-->
<#include "cpy_footer.ftl"/>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</body>
</html>
