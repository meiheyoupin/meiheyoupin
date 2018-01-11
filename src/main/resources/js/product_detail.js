$(function () {
    $(".Buy").on("click", function () {
        var goodsId = $("#goodsId").html();
        var goodsIdAndCountList = [{
            'id': goodsId,
            'count': 1
        }];
        var data = {
            "goodsIdAndCountListJson": JSON.stringify(goodsIdAndCountList),
            "userId": 1,
            "token": new Date().getTime()
        };
        $.base64.utf8encode = true;
        var dataEncoded = $.base64.btoa(JSON.stringify(data));
        window.location.href =  "/order?d=" + dataEncoded;

    });

        $(".a-item").click(function(){
            $(this).addClass("active").parent().siblings().children().removeClass("active");
        });
        $(document).scroll(function () {
            $(document).scrollTop()>=700&&($("#affix").css({'top':'0px'}))
            $(document).scrollTop()<=700&&($("#affix").css({'top':'-120px'}))
        });
});

