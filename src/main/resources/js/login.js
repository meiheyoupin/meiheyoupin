function changeUrl() {
    var validate = $("#code-validate");
    var url = validate.prop("src");
    url = url.substr(0, url.lastIndexOf('/') + 1);
    url = url + (new Date()).valueOf();
    validate.prop('src', url);
    return false;
}

$(function () {
    /* 登录 */
    var loginButton = $("#loginButton");
    var loginForm = $("#loginForm");
    var loginInputTel = $("#loginInputTel");
    var loginInputPassword = $("#loginInputPassword");
    var loginInputVerification = $("#loginInputVerification");

    /* 登录处理 */
    loginButton.on("click", function () {
        var form = new FormData();
        form.append("tel", loginInputTel.val());
        form.append("password", loginInputPassword.val());
        form.append("verification", loginInputVerification.val());
        $.ajax({
            url: '/login',
            type: 'post',
            data: form,
            processData: false,
            contentType: false,
            success: function (response) {
                if (response.state === 0) {
                    localStorage.setItem("userTel", response.data.userInfo.tel);
                    localStorage.setItem("userId", response.data.userInfo.id);
                    localStorage.setItem("username", response.data.userInfo.contactsName);
                    var currentUrl = window.location.href;
                    if (currentUrl.lastIndexOf("/login") !== -1) {
                        window.location.href = "/";
                    } else {
                        window.location.reload();
                    }
                } else {
                    $("#error").html(response.message + "！").show();
                }
            }
        });

        return false;
    });
});



