$(function () {

    //获取短信验证码
    function getMAC() {
        var form = new FormData();
        form.append("tel", $("#tel").val());
        $.ajax({
            url: '/getMAC',
            type: "post",
            data: form,
            processData: false,
            contentType: false,
            success: function (data) {
            }
        });

    }

    var sendable = true;

    $(function () {
        $("#btn-code").click(function () {
            var tel = $("#tel").val();
            var pattern = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
            if (pattern.test(tel)) {
                if (sendable) {
                    getMAC();
                    setTime(this);
                }
            }

        });
    });

    // 注册
    var registerButton = $("#submit");
    var registerInputTel = $("#tel");
    var registerInputCode = $("#code");
    var registerInputCpyContacts = $("#cpy-tacts");
    var registerInputCpynName = $("#cpy-name");
    var registerInputCpyAddr = $("#cpy-addr");
    var registerInputCertificatePhoto = $("#certificate-photo");
    var registerInputLicencePhoto = $("#licence-photo");
    var registerInputIDCPhoto1 = $("#idc-photo1");
    var registerInputIDCPhoto2 = $("#idc-photo2");
    var registerInputOutsidePhoto = $("#outside-photo");
    var registerInputInsidePhoto1 = $("#inside-photo1");
    var registerInputInsidePhoto2 = $("#inside-photo2");


    for (let i = 0; i < 5; i++) {
        $('.dingwei').eq(i).find('i').hide()
        $('.dingwei>input').eq(i).focus(function () {
            $(this)[0].placeholder = '';
            $('#label label').eq(i).fadeIn(500);
            $('#prompt p').eq(i).fadeIn(500);
        })
    }
//input表单获取焦点提示
    function testHeight(ele) {
        if (ele.html().length <= 10) {
            ele.css({'line-height': '45px'})
        }
        else {
            ele.css({'line-height': '22px'})
        }
    }

    for (let i = 0; i < 5; i++) {
        testHeight($('#prompt p').eq(i))
    }

//  选择性别按钮
    $(".btn-gentle").click(function () {
        $(".btn-gentle").addClass('active').siblings().removeClass('active');
    });
    $(".btn-ladie").click(function () {
        $(".btn-ladie").addClass('active').siblings().removeClass('active');
    });

//  发送验证码倒计时
    var countdown = 60;

    function setTime(obj) {
        if (countdown == 0) {
            obj.removeAttribute("disabled");
            obj.value = "免费获取验证码";
            countdown = 60;
            sendable = true;
            return;
        } else {
            obj.setAttribute("disabled", true);
            obj.value = countdown + " 秒后重试";
            countdown--;
            sendable = false;
        }
        setTimeout(function () {
            setTime(obj)
        }, 1000);
    }

    function checkTel() {
        var tel = registerInputTel.val();
        var pattern = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
        if (pattern.test(tel)) {
            $.ajax({
                url: '/store/checkTel',
                type: "post",
                data: {
                    "tel": tel
                },
                success: function (data) {
                    if (data.message) {
                        alert(data.message);
                        return false;
                    } else {
                        $('.p_tel').hide();
                        $('.icon-tel').show(200);
                        $('#btn-code').fadeIn(500).css({'background': '#fed500', 'color': '#fff', 'border-color': '#fed500'});
                        return true;
                    }
                }
            });

        } else {
            $('.p_tel').show();
            $('.icon-tel').hide(200);
            $('#btn-code').fadeIn(500).css({'background': '#F0F0F0', 'color': '#6a6a6a'});
            return false;
        }
    }

    function checkCode() {
        var code = registerInputCode.val();
        var pattern = /^\d{6}$/;
        if (pattern.test(code)) {
            $('.p_code').hide();
            $('.icon-code').show(200);
            return true;
        } else {
            $('.p_code').show();
            $('.icon-code').hide(200);
            return false;
        }
    }

    function checkCpyContacts() {
        var cpycontacts = registerInputCpyContacts.val();
        var pattern = /^\S{2,4}$/;
        if (pattern.test(cpycontacts)) {
            $('.p_tact').hide();
            $('.icon-tact').show(200);
            return true;
        } else {
            $('.p_tact').show();
            $('.icon-tact').hide(200);
            return false;
        }
    }

    function checkCpyName() {
        var cpyname = registerInputCpynName.val();
        var pattern = /^\S{2,}$/;
        if (pattern.test(cpyname)) {
            $('.p_name').hide();
            $('.icon-nm').show(200);
            return true;
        } else {
            $('.p_name').show();
            $('.icon-nm').hide(200);
            return false;
        }
    }

    function checkCpyAddr() {
        var cpyaddr = registerInputCpyAddr.val();
        var pattern = /^\S{6,30}$/;
        if (pattern.test(cpyaddr)) {
            $('.p_addr').hide();
            $('.icon-addr').show(200);
            return true;
        } else {
            $('.p_addr').show();
            $('.icon-addr').hide(200);
            return false;
        }

    }

    function checkCertificatePhoto() {
        var url = registerInputCertificatePhoto.attr("value");
        return !!url;
    }

    function checkLicencePhoto() {
        var url = registerInputLicencePhoto.attr("value");
        return !!url;
    }

    function checkIDCPhoto1() {
        var url = registerInputIDCPhoto1.attr("value");
        return !!url;
    }

    function checkIDCPhoto2() {
        var url = registerInputIDCPhoto2.attr("value");
        return !!url;
    }

    function checkOutsidePhoto() {
        var url = registerInputOutsidePhoto.attr("value");
        return !!url;
    }

    function checkInsidePhoto1() {
        var url = registerInputInsidePhoto1.attr("value");
        return !!url;
    }

    function checkInsidePhoto2() {
        var url = registerInputInsidePhoto2.attr("value");
        return !!url;
    }

    // 注册校验
    registerInputTel.on("blur", function () {
        checkTel();
    });
    registerInputCode.on("blur", function () {
        checkCode();
    });
    registerInputCpynName.on("blur", function () {
        checkCpyName();
    });
    registerInputCpyContacts.on("blur", function () {
        checkCpyContacts();
    });
    registerInputCpyAddr.on("blur", function () {
        checkCpyAddr();
    });


    // 注册处理
    registerButton.on("click", function () {
        if (checkTel() && checkCode() && checkCpyName() && checkCpyContacts() && checkCpyAddr() && checkOutsidePhoto() && checkCertificatePhoto()
            && checkLicencePhoto() && checkIDCPhoto1() && checkIDCPhoto2() && checkInsidePhoto1() && checkInsidePhoto2()) {
            var form = new FormData();
            form.append("tel", registerInputTel.val());
            form.append("verificationCode", registerInputCode.val());
            form.append("storeName", registerInputCpynName.val());
            form.append("bossName", registerInputCpyContacts.val());
            form.append("storeAddr", registerInputCpyAddr.val());
            form.append("storeOutsidePhotoUrl", registerInputOutsidePhoto.val());
            form.append("storeLicencePhotoUrl", registerInputOutsidePhoto.val());
            form.append("bossIdcardPhotoUrl1", registerInputIDCPhoto1.val());
            form.append("bossIdcardPhotoUrl2", registerInputIDCPhoto2.val());
            form.append("certificatePhotoUrl", registerInputCertificatePhoto.val());
            form.append("storeInsidePhotoUrl1", registerInputInsidePhoto1.val());
            form.append("storeInsidePhotoUrl2", registerInputInsidePhoto2.val());
            var selectedGender = $(".active");
            var gender = selectedGender ? selectedGender.attr("gender") : 1;
            form.append("bossGender", gender);

            $.ajax({
                url: '/store/register',
                type: "post",
                data: form,
                processData: false,
                contentType: false,
                success: function (response) {
                    if (response.state === 0) {
                        alert("注册成功");
                    } else {
                        alert("注册失败: " + response.data.error);
                    }
                }
            });
        }

    });

    function bindChange(fileInput) {
        fileInput.on("change", function () {
            var filePath = $(this).val();
            if (filePath.indexOf("jpg") !== -1 || filePath.indexOf("png") !== -1) {
                $(this).parent().parent().find(".fileerrorTip").html("").hide();
                var arr = filePath.split('\\');
                var fileName = arr[arr.length - 1];
                $(this).parent().parent().find(".showFileName").html(fileName).css({"color": "#35b558"});
            } else {
                $(this).parent().parent().find(".showFileName").html("");
                $(this).parent().parent().find(".fileerrorTip").html("仅支持 jpg/png 格式图片上传！").show();
                return false;
            }

            var form = new FormData();
            form.append("file", this.files[0]);
            $.ajax({
                url: '/file/multipleCommentImageUpload', //用于文件上传的服务器端请求地址
                type: 'post',
                processData: false, // 告诉jQuery不要去处理发送的数据
                contentType: false, // 告诉jQuery不要去设置Content-Type请求头
                data: form,
                cache: false,
                success: function (data) {
                    if (data.state === 0) {
                        fileInput.attr("value", data.data.url);
                    } else {
                        fileInput.parent().parent().find(".fileerrorTip").html("上传失败").show();
                    }
                }
            });

        });
    }

    //绑定图片上传事件监听器
    bindChange(registerInputCertificatePhoto);
    bindChange(registerInputLicencePhoto);
    bindChange(registerInputIDCPhoto1);
    bindChange(registerInputIDCPhoto2);
    bindChange(registerInputOutsidePhoto);
    bindChange(registerInputInsidePhoto1);
    bindChange(registerInputInsidePhoto2);


});