function auditGood() {
    var goodIds = [];
    var goodId = $("#goodId").val();
    var toInt = Number(goodId);
    console.log(toInt);
    goodIds.push(toInt);
    $.ajax({
        url:'platform/auditGoods',
        type:'get',
        data:{
            goodIds:goodIds
        },
        datatype:'text',
        headers: {
            "token": localStorage.getItem("token")
        },
        traditional: true,
        success:function (data) {
          if (data.code==200){
            window.location.href='/cpyPack';
          }else if (data.code==401){
            alert("对不起，您没有权限")
          }else if (data.code==500){
            alert("服务器内部错误")
          }
        }
    })
}

function unsanctionedGood() {
    var goodIds = [];
    var goodId = $("#goodId").val();
    var toInt = Number(goodId);
    console.log(toInt);
    goodIds.push(toInt);
    var obj = document.getElementsByName("reason");
    var reason ='';
    for (var i=0;i<obj.length;i++){
        if(obj[i].checked) reason+=obj[i].value+' ';
    }
    console.log(reason);
    $.ajax({
        url:'platform/unsanctionedGood',
        type:'post',
        data:{
            goodIds:goodIds,
            reason:reason
        },
        datatype:'text',
        headers: {
            "token": localStorage.getItem("token")
        },
        traditional: true,
        success:function (data) {
          if (data.code==200){
            window.location.href='/cpyPack';
          }else if (data.code==401){
            alert("对不起，您没有权限")
          }else if (data.code==500){
            alert("服务器内部错误")
          }
        }
    })
}

/*
//套餐审核弹框
$(".info-check").click(function(){
    $("#pack").show();
    $("#MyPack").show();
});
$(".onClose").click(function(){
    $("#pack").hide();
    $("#MyPack").hide();
});
//审核通过弹框
$(".pass").click(function(){
    $("#pass").show();
    $("#MyPass").show();
});
$(".back").click(function(){
    $("#pass").hide();
    $("#MyPass").hide();
});
//审核未通过弹框
$(".not").click(function(){
    $("#not").show();
    $("#MyNot").show();
});
$(".btn-back, .btn-send").click(function(){
    $("#not").hide();
    $("#MyNot").hide();
});*/
