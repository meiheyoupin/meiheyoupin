$(function () {
    var loginToken = $.cookie("loginToken");
    var headButton = $(".right-part li");
    if (loginToken) {
        headButton.eq(1).hide();
        headButton.eq(2).hide();
        headButton.eq(3).show();
        headButton.eq(0).find("a").html(localStorage.getItem("username"));
        headButton.eq(0).show();

    } else {
        headButton.eq(1).show();
        headButton.eq(2).show();
        headButton.eq(3).hide();
    }

    var formData = new FormData();
    $.ajax({
        url: "/recommended",
        type: "post",
        data: formData,
        processData: false,
        contentType: false,
        success: function (response) {
            if (response.state === 0) {
                var html = template("goodsListTemplate", response.data);
                $("#recommendedProducts").append(html);
            } else {
                alert("出现了错误...");
            }
        }
    });


//banner轮播
    var i = 0;
    $(function () {
        $(".slide").eq(0).show().siblings().hide();
        setInterval(function () {
            i++;
            if (i == 3) {
                i = 0;
            }
            $(".slide").eq(i).fadeIn(1000).siblings().fadeOut(1000);
        }, 3500);
    });
//滚动触发搜索框
    $(document).scroll(function () {
        $(document).scrollTop() >= 700 && ($("#nav").css({'top': '0px'}))
        $(document).scrollTop() <= 700 && ($("#nav").css({'top': '-60px'}))
    });
//广告点击事件
    $("#fl_open_wrap").click(function () {
        $("#fl_pop_wrap").show(800).siblings().hide(400);
    });
    $(".pop_close").click(function () {
        $("#fl_pop_wrap").hide(800).siblings().show(1000);
    });
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
//返回顶部按钮
$('.top1').hover(function(){
    $(".inner-text1").show();
},function(){
    $(".inner-text1").hide();
});
$('.top2').hover(function(){
    $(".inner-text2").show();
    $(".inner-box").show();
},function(){
    $(".inner-text2").hide();
    $(".inner-box").hide();
});
$('.top3').hover(function(){
    $(".inner-text3").show();
},function(){
    $(".inner-text3").hide();
});
//首页红包雨
//		var minSize=5;
//		var maxSize=50;
//		var newOn=500;
//		var flakeColor="#fff";
//		var flake=$("<div></div>").css({"z-index":"10","position":"absolute","top":"-50px"}).html("<img src='img/red-packet.png'>");
//		$(function(){
//			var documentHeight = $(document).height();
//			var documentWidth = $(document).width();
//			setInterval(function(){
//				var startPostionLeft = Math.random()*documentWidth;
//				var startOpacity = 0.7+Math.random()*0.3;
//				var endPositionTop = documentHeight;
//				var endPositionLeft = Math.random()*documentWidth;
//				var durationFall = 6000+Math.random()*3000;
//				var sizeFlake = minSize+Math.random()*maxSize;
//				flake.clone().appendTo("body").css({
//					"left":startPostionLeft,
//					"opacity":startOpacity,
//					"font-size":sizeFlake,
//					"color":flakeColor
//				}).animate({
//					"top":endPositionTop,
//					"left":endPositionLeft,
//					"opcity":0.5
//				},durationFall,function(){$(this).remove();});
//			},newOn);
//		});

});