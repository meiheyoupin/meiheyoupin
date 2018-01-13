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
