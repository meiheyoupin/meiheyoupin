//确认订单
$('.onBuy').click(function () {
    $(".payment").show(150);
});
//用户订单
$('.onBoon').click(function () {
    $("#for_boon").show().siblings().hide();
    $(".hd_boon").show().siblings().hide();
});
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
//订单hidden
$('.spread').click(function () {
    $(".boon-info").toggle(200);
});
$('.spread').click(function () {
    $(".custom-info").toggle(200);
});
$('.spread').click(function () {
    $(".eval-info").toggle(200);
});
$('.spread').click(function () {
    $(".refund-info").toggle(200);
});
//******MERCHANT左侧导航点击事件
$('.onCheck').click(function () {
    $("#for_check").show().siblings().hide();
    $(".hd_check").show().siblings().hide();
});
$('.onAdd').click(function () {
    $("#for_add").show().siblings().hide();
    $(".hd_add").show().siblings().hide();
});
$('.onNew').click(function () {
    $("#new_order").show().siblings().hide();
    $(".hd_new").show().siblings().hide();
});
$('.onReceipt').click(function () {
    $("#receipt").show().siblings().hide();
    $(".hd_receipt").show().siblings().hide();
});
$('.onComplete').click(function () {
    $("#complete").show().siblings().hide();
    $(".hd_complete").show().siblings().hide();
});
$('.onUnit').click(function () {
    $("#unit").show().siblings().hide();
    $(".hd_unit").show().siblings().hide();
});
$('.onSum').click(function () {
    $("#sum").show().siblings().hide();
    $(".hd_sum").show().siblings().hide();
});
$('.onData').click(function () {
    $("#data").show().siblings().hide();
    $(".hd_data").show().siblings().hide();
});
$('.onAlter').click(function () {
    $("#alter").show().siblings().hide();
    $(".hd_alter").show().siblings().hide();
});
//查看商品显示菜单		
$(".cut1").click(function () {
    $(".table1").toggle();
});
$(".cut2").click(function () {
    $(".table2").toggle();
});
$(".cut3").click(function () {
    $(".table3").toggle();
});
$(".cut4").click(function () {
    $(".table4").toggle();
});
$(".cut5").click(function () {
    $(".table5").toggle();
});
$(".cut6").click(function () {
    $(".table6").toggle();
});
//查看商品修改删除
$(".alter1").click(function () {
    $(".check-alter1").toggle();
});
$(".close1").click(function () {
    $(".check-alter1").toggle();
});
$(".alter2").click(function () {
    $(".check-alter2").toggle();
});
$(".close2").click(function () {
    $(".check-alter2").toggle();
});
$(".alter3").click(function () {
    $(".check-alter3").toggle();
});
$(".close3").click(function () {
    $(".check-alter3").toggle();
});
$(".alter4").click(function () {
    $(".check-alter4").toggle();
});
$(".close4").click(function () {
    $(".check-alter4").toggle();
});
$(".alter5").click(function () {
    $(".check-alter5").toggle();
});
$(".close5").click(function () {
    $(".check-alter5").toggle();
});
$(".alter6").click(function () {
    $(".check-alter6").toggle();
});
$(".close6").click(function () {
    $(".check-alter6").toggle();
});
//添加商品文件上传提示			
$(".file").on("change", "input[type='file']", function () {
    var filePath = $(this).val();
    if (filePath.indexOf("jpg") != -1 || filePath.indexOf("png") != -1) {
        $(".fileerrorTip").html("").hide();
        var arr = filePath.split('\\');
        var fileName = arr[arr.length - 1];
        $(".showFileName").html(fileName);
    } else {
        $(".showFileName").html("");
        $(".fileerrorTip").html("您上传文件类型有误！").show();
        return false
    }
})
//header退货logo鼠标事件	
$(document).ready(function () {
    $(".tui").hover(function () {
        $(".refund").css("display", "block");
    }, function () {
        $(".refund").css("display", "none");
    });
    $(".pei").hover(function () {
        $(".mid").css("display", "block");
    }, function () {
        $(".mid").css("display", "none");
    });
});
//员工生日提醒
$('.add').click(function () {
    $(".add_up").show();
});
$('.btn_up').click(function () {
    $(".add_up").hide();
});
option = {
    color: ['#3398DB'],
    tooltip: {
        trigger: 'axis',
        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: [
        {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
            axisTick: {
                alignWithLabel: true
            }
        }
    ],
    yAxis: [
        {
            type: 'value'
        }
    ],
    series: [
        {
            name: '直接访问',
            type: 'bar',
            barWidth: '60%',
            data: [10, 52, 200, 334, 390, 330, 220]
        }
    ]
};


//注册**********************
var sec = 3;
$("#submit").click(function () {
    window.setInterval(function () {
        if (sec >= 1) {
            sec--;
            $("#tips").html(sec);
        } else {
            $("#tips").html(sec);
            window.open("login.html", "_parent");
        }
    }, 1000);
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
