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
            window.location.href='/cpyPack';
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
        success:function () {
            window.location.href='/cpyPack';
        }
    })
}