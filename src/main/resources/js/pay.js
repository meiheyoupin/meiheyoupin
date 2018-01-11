$(function () {
    // history.pushState(null, null, document.URL);
    // window.addEventListener('popstate', function () {
    //     history.pushState(null, null, document.URL);
    // });

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        var img = document.getElementById("payCode");
        img.src = URL.createObjectURL(this.response);
        img.onload = function (e) {
            window.URL.revokeObjectURL(this.src);
            setInterval(checkOrderState, 6000);
        };

    };
    xhr.open("POST", "/wxpay/pay", true);
    xhr.responseType = "blob";
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var params = "name=" + $(".order-type strong").html() + "&orderNumber=" + $(".order-num strong").html();
    var userId = localStorage.getItem("userId");
    if (userId) {
        params += "&userId=" + localStorage.getItem("userId");
    }
    xhr.send(params);


    function checkOrderState() {
        var form = new FormData();
        form.append("orderNumber", $(".order-num strong").html());
        $.ajax({
            url: "/order/state",
            type: "post",
            dataType: "json",
            data: form,
            processData: false,
            contentType: false,
            success: function (data) {
                if (data.state === 0 && data.data.orderState === 2) {
                    var orderNumber = encodeBase64($(".order-num strong").html());
                    var orderName = encodeBase64($(".order-type strong").html());
                    window.location.href = "/pay/success?o=" + orderNumber + "&n=" + orderName;
                }
            }
        });
    }

    function encodeBase64(str, times) {
        var code = "";
        var num = 1;
        if (typeof times === 'undefined' || times === null || times === "") {
            num = 1;
        } else {
            var vt = times + "";
            num = parseInt(vt);
        }
        if (typeof str === 'undefined' || str === null || str === "") {
        } else {
            $.base64.utf8encode = true;
            code = str;
            for (var i = 0; i < num; i++) {
                code = $.base64.btoa(code);
            }
        }
        return code;
    }

});