$(function () {
    //套餐审核弹框
    var list = document.getElementsByClassName("shoplist");
    for (let i=0;i<list.length;i++){
        $(".info-check").eq(i).click(function(){
            $(".Shop").eq(i).show();
            $(".MyShop").eq(i).show();
        });
        $(".onClose").eq(i).click(function(){
            $(".Shop").eq(i).hide();
            $(".MyShop").eq(i).hide();
        });
    }

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
    });
});

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
        success:function () {
            window.location.href='/cpyShop';
        }
    })
}
