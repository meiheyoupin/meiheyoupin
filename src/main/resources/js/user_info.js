$("#userInfo").attr("href", "/user/" + localStorage.getItem("userId"));
$("#payOrder").attr("href", "/order/query?s=1&u=" + localStorage.getItem("userId"));

$(function () {
    var userInfoSaveButton = $("#userInfoSaveButton");
    var userInfoTel = $("#userInfoTel");
    var userInfoCpyName = $("#userInfoCpyName");
    var userInfoCpyDepartment = $("#userInfoCpyDepartment");
    var userInfoCpyAddr = $("#userInfoCpyAddre");
    var userInfoCpyContacts = $("#userInfoCpyContacts");
    var userInfoCpyIntroduces = $("#userInfoCpyIntroduces");

    userInfoSaveButton.on("click", function () {
        var form = new FormData();
        form.append("id", localStorage.getItem("userId"));
        form.append("tel", userInfoTel.val());
        form.append("companyName", userInfoCpyName.val());
        form.append("companyDepartment", userInfoCpyDepartment.val());
        form.append("companyAddr", userInfoCpyAddr.val());
        form.append("contactsName", userInfoCpyContacts.val());
        form.append("companyIntroduce", userInfoCpyIntroduces.val());
        $.ajax({
            url: '/modifyUserInfo',
            type: 'post',
            data: form,
            processData: false,
            contentType: false,
            success: function (response) {
                if (response.state === 0) {
                    alert("保存成功");
                } else {
                    alert("保存失败");
                }
            }
        });
    });
});

//弹出隐藏层
function ShowDiv(show_div, bg_div) {
    document.getElementById(show_div).style.display = 'block';
    document.getElementById(bg_div).style.display = 'block';
    var bgdiv = document.getElementById(bg_div);
    bgdiv.style.width = document.body.scrollWidth;
    //bgdiv.style.height = $(document).height();
    $("#" + bg_div).height($(document).height());
};
//关闭弹出层
function CloseDiv(show_div, bg_div) {
    document.getElementById(show_div).style.display = 'none';
    document.getElementById(bg_div).style.display = 'none';
};

$('.onCustom').click(function () {
    $("#for_custom").show().siblings().hide();
    $(".hd_custom").show().siblings().hide();
});
$('.onPay').click(function () {
    $("#for_pay").show().siblings().hide();
    $(".hd_pay").show().siblings().hide();
});
$('.onEval').click(function () {
    $("#for_eval").show().siblings().hide();
    $(".hd_eval").show().siblings().hide();
});
$('.onRefund').click(function () {
    $("#for_refund").show().siblings().hide();
    $(".hd_refund").show().siblings().hide();
});
$('.onData').click(function () {
    $("#data").show().siblings().hide();
    $(".hd_data").show().siblings().hide();
});
$('.onAddress').click(function () {
    $("#address").show().siblings().hide();
    $(".hd_address").show().siblings().hide();
});
$('.onAlter').click(function () {
    $("#alter").show().siblings().hide();
    $(".hd_alter").show().siblings().hide();
});
