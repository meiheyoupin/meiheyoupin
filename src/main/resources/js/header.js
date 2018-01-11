/**
 * Created by 123 on 2018/1/9.
 */
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
