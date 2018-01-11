/**
 * Created by w2tto on 2018/1/4.
 */
$(function () {
  var aliPayButton = $("#aliPayButton");
  var orderNumber = $(".order-num strong").html();
  var orderName = $(".order-type strong").html();

  aliPayButton.on("click", function () {

    var form = new FormData();
    form.append("orderNumber", orderNumber);
    form.append("Name", orderName);
    $.ajax({
      url: '/alipay/pay',
      type: 'post',
      data: form,
      processData: false,
      contentType: false,
      success: function (data) {
        $("#main").append(data.data);
      }
    });
  });
});

// 订单查询
$(function () {
  var aliPayOrderQuery = $("#aliPayOrderQuery");

  aliPayOrderQuery.on("click",function () {
    var form = new FormData();
    form.append("orderNumber", $(".order-num strong").html());
    $.ajax({
      url: '/alipay/orderquery',
      type: 'post',
      data: form,
      processData: false,
      contentType: false,
      success: function (data) {
        $("#").append(data.data);
      }
    });
  });
});




