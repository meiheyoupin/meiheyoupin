$("#userInfo").attr("href", "/user/" + localStorage.getItem("userId"));
$("#payOrder").attr("href", "/order/query?s=1&u=" + localStorage.getItem("userId"));

$(".btn-again a").on("click", function () {
    $.base64.utf8encode = true;
    var orderId = $.base64.btoa($("#orderId").html());
    var userId = $.base64.btoa((localStorage.getItem("userId")));
    window.location.href = "/pay?o=" + orderId + "&u=" + userId;
});