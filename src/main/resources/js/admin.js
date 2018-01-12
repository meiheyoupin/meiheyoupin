$(function () {
    var token = localStorage.getItem("token");
    if (token){
        console.log('has token!')
        $.ajaxSetup({
            dataType: "json",
            cache: false,
            headers: {
                "token": token
            },
        });
    }else {
        console.log('no token!')
        window.location.href="/admin"
    }
})

//get管理员列表
function getAdministrator() {
    $.ajax({
        url:"platform/administrators",
        type:"get",
        success:function (data) {

        }
    })
    
}

//get未审核商品列表
function getUnauditGoods() {
    $.ajax({
        url:"platform/unauditGoods",
        type:"get",
        success:function (data) {

        }
    })

}

//get未审核商家列表
function getUunauditStores() {
    $.ajax({
        url:"platform/unauditStores",
        type:"get",
        success:function (data) {

        }
    })

}