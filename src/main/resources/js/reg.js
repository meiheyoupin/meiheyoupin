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
    var registerInputPwd1 = $("#pwd1");
    var registerInputPwd2 = $("#pwd2");
    var registerInputCpynName = $("#cpy-name");
    var registerInputCpyDepartment = $("#cpy-department");
    var registerInputCpyAddr = $("#cpy-addr");
    var registerInputCpyContacts = $("#cpy-tacts");
    var registerInputInvitation = $("#yq");
    var registerInputCpyIntro = $("#cpy-intro");

    for (let i = 0; i < 9; i++) {
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

    for (let i = 0; i < 9; i++) {
        testHeight($('#prompt p').eq(i))
    }
    // 选择性别按钮
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

    // 注册校验

    function checkTel() {
        var tel = registerInputTel.val();
        var pattern = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
        if (pattern.test(tel)) {
            $('.p_tel').hide();
            $('.icon-tel').show(200);
            $('#btn-code').fadeIn(500).css({'background': '#fed500', 'color': '#fff', 'border-color': '#fed500'});
            return true;
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

    function checkCpyName() {
        var cpyname = registerInputCpynName.val();
        var pattern = /^\S{2,}$/;
        if (pattern.test(cpyname)) {
            $('.p_nm').hide();
            $('.icon-nm').show(200);
            return true;
        } else {
            $('.p_nm').show();
            $('.icon-nm').hide(200);
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

    function checkPwd1() {
        var pwd1 = registerInputPwd1.val();
        var pattern = /^\w{6,20}$/;
        if (pattern.test(pwd1)) {
            $('.p_pwd1').hide();
            $('.icon-pwd1').show(200);
            return true;
        } else {
            $('.p_pwd1').show();
            $('.icon-pwd1').hide(200);
            return false;
        }
    }

    function checkPwd2() {
        var pwd = registerInputPwd2.val();
        var pwd1 = registerInputPwd1.val();
        if (pwd === pwd1) {
            $('.p_pwd2').hide();
            $('.icon-pwd2').show(200);
            return true;
        } else {
            $('.p_pwd2').show();
            $('.icon-pwd2').hide(200);
            return false;
        }
    }

    function checkCpyDepartment() {
        var cpydepartment = registerInputCpyDepartment.val();
        var pattern = /^\S{2,12}$/;
        if (pattern.test(cpydepartment)) {
            $('.p_dep').hide();
            $('.icon-dep').show(200);
            return true;
        } else {
            $('.p_dep').show();
            $('.icon-dep').hide(200);
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
    registerInputPwd1.on("blur", function () {
        checkPwd1();
    });
    registerInputPwd2.on("blur", function () {
        checkPwd2();
    });
    registerInputInvitation.on("blur", function () {
        $(".p_yq").hide();
    });
    registerInputCpyDepartment.on("blur", function () {
        checkCpyDepartment();
    });
    registerInputCpyAddr.on("blur", function () {
        checkCpyAddr();
    });

    // 注册处理
    registerButton.on("click", function () {

        if (checkTel() && checkCode() && checkCpyName() && checkCpyContacts() && checkPwd1() && checkPwd2() && checkCpyDepartment() && checkCpyAddr()) {
            var form = new FormData();
            form.append("tel", registerInputTel.val());
            form.append("verificationCode", registerInputCode.val());
            form.append("password", registerInputPwd1.val());
            form.append("confirmPassword", registerInputPwd2.val());
            form.append("invitationCode", registerInputPwd2.val());
            form.append("companyName", registerInputCpynName.val());
            form.append("companyDepartment", registerInputCpyDepartment.val());
            form.append("companyAddr", registerInputCpyAddr.val());
            form.append("contactsName", registerInputCpyContacts.val());
            form.append("invitationCode", registerInputInvitation.val());

            var selectedGender = $(".active");
            var gender = selectedGender ? selectedGender.attr("gender") : 1;
            form.append("contactsGender", gender);
            form.append("companyIntroduce", registerInputCpyIntro.val());

            $.ajax({
                url: '/register',
                type: "post",
                data: form,
                processData: false,
                contentType: false,
                success: function (data) {
                    if (data !== null && data.state === 0) {
                        $("#MyDiv").show();
                        $("#fade").show();
                        var sec = 3;
                        window.setInterval(function () {
                            if (sec >= 1) {
                                sec--;
                                $("#tips").html(sec);
                            } else {
                                $("#tips").html(sec);
                                window.open("/login", "_parent");
                            }
                        }, 1000);
                    } else {
                        var tip = $(".p_sub");
                        tip.html(data.data.error);
                        tip.css("color", "	#FF2D2D");
                        tip.show();
                    }

                }
            });
        }

    });

});