$(function () {
    //弹出隐藏层
    function ShowDiv(show_div, bg_div) {
        document.getElementById(show_div).style.display = 'block';
        document.getElementById(bg_div).style.display = 'block';
        var bgdiv = document.getElementById(bg_div);
        bgdiv.style.width = document.body.scrollWidth;
        $("#" + bg_div).height($(document).height());
    }

    //关闭弹出层
    function CloseDiv(show_div, bg_div) {
        document.getElementById(show_div).style.display = 'none';
        document.getElementById(bg_div).style.display = 'none';
    }

    $(".submit").on("click", function () {
        var data = new FormData();
        data.append("contactsTel", $(".phone input:first").val());
        data.append("contactsName", $(".phone input:last").val());
        $.ajax({
            url: "/demand",
            type: "post",
            data: data,
            processData: false,
            contentType: false,
            success: function (result) {
                ShowDiv('MyDiv', 'fade');
            }
        });


    });


});