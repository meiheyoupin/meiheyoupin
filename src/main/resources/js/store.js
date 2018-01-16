
function auditStore() {
    var storeIds = [];
    var storeId = $("#storeId").val();
    var toInt = Number(storeId);
    console.log(toInt);
    storeIds.push(toInt);
    $.ajax({
        url:'platform/auditStores',
        type:'get',
        data:{
            storeIds:storeIds
        },
        datatype:'text',
        headers: {
            "token": localStorage.getItem("token")
        },
        traditional: true,
        success:function (data) {
          if (data.code==200){
            window.location.href='/cpyStore';
          }else if (data.code==401){
            alert("对不起，您没有权限")
          }else if (data.code==500){
            alert("服务器内部错误")
          }
        }
    })
}



function unsanctionedStore() {
    var storeIds = [];
    var storeId = $("#storeId").val();
    var toInt = Number(storeId);
    console.log(toInt);
    storeIds.push(toInt);
    var obj = document.getElementsByName("reason");
    var reason ='';
    for (var i=0;i<obj.length;i++){
        if(obj[i].checked) reason+=obj[i].value+' ';
            /*$("#not").hide();
            $("#MyNot").hide();*/

            $.ajax({
                url:'platform/unsanctionedStore',
                type:'post',
                data:{
                    storeIds:storeIds,
                    reason:reason
                },
                datatype:'text',
                headers: {
                    "token": localStorage.getItem("token")
                },
                traditional: true,
                success:function (data) {
                    if (data.code==200){
                        window.location.href='/cpyStore';
                    }else if (data.code==401){
                        alert("对不起，您没有权限")
                    }else if (data.code==500){
                        alert("服务器内部错误")
                    }

                }
            })
        /*else{
            return false;
        }*/
    }

}

/*//店铺审核弹框
$(".ck-shop").click(function(){
    $("#store").show();
});
$(".close").click(function(){
    $("#store").hide();
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
$(".btn-back").click(function(){
    $("#not").hide();
    $("#MyNot").hide();
});*/



/*const vm = new Vue({
 el:'#app',
 data:{
 list:{}
 },
 created:function () {
 var that = this
 $.ajax({
 url:'platform/unauditStores',
 type:'get',
 datatype:'json',
 success:function (data) {
 console.log(data);
 if(data.code==200){
 that.list = data.unauditStores;
 }else {
 alert("default");
 }
 }
 })
 }
 });*/
