$(function () {
  /* 登录 */
  var loginButton = $("#loginButton");
  var loginForm = $("#loginForm");
  var loginInputName = $("#loginInputName");
  var loginInputPassword = $("#loginInputPassword");

  /* 登录处理 */
  // loginButton.on("click", function (event) {
  //   var event = event || window.event;
  //   event.preventDefault();
  //   var form = new FormData();
  //   form.append("adminName", loginInputName.val());
  //   form.append("adminPassword", loginInputPassword.val());
  //   console.log(form)
  //   $.ajax({
  //     url: '/adminLogin',
  //     type: 'post',
  //     data: form,
  //     processData: false,
  //     contentType: false,
  //     success: function (data) {
  //       if (data.code == 200) {
  //         console.log(data.token);
  //         localStorage.setItem("token", data.token);
  //         window.location.href="/cpyPerson";
  //       } else {
  //         //此处写登陆失败的方法...
  //         alert("登录失败:" + data.code);
  //       }
  //     }
  //   });
  // });
});
function adminIndex() {
    $.ajax({
        url:"platform/auditStores",
        type:'get',
        data:null,
        headers: {
            "token": localStorage.getItem("token")
        },
        success:function () {
            window.location.href="/cpyPerson";
        }
    })
}
/*
$("#submit").click(() = > {
  if($("#tel").val() && $("#password").val()
)
{
  $.ajax({
    type: 'post',
    url: '',
    data: {
      name: $("#tel").val(),
      pwd: $("#password").val(),
      purpose: 'query',
      anopur: 1
    }
  }).then(data = > {
    console.log(!data.length)
  if (data.length) {
    $("#cover").fadeIn(10)
    $("#tishi").fadeIn(500)
    let num = 4;
    setInterval(() = > $("#tishi span").html(num--), 1000
  )
    setTimeout(() = > location.replace('index.html'), 5000
  )
  } else {
    $("#error").finish().fadeOut(10).html('账号和密码不匹配，请重新输入!').fadeIn(100)
    $("#submit").attr('disabled', 'disabled')
    setTimeout(() = >
    {$("#submit"
  ).
    removeAttr('disabled')
  },
    1000
  )
  }
})
}
else
{
  console.log()
  $("#error").html('用户名或密码不能为空').fadeIn(100)
}
})


//var code ; //在全局定义验证码
//产生验证码
window.onload = function createCode() {
  code = "";
  var codeLength = 4;//验证码的长度
  var checkCode = document.getElementById("code");
  var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
    'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');//随机数
for (var i = 0; i < codeLength; i++) {//循环操作
  var index = Math.floor(Math.random() * 36);//取得随机数的索引（0~35）
  code += random[index];//根据索引取得随机数加到code上
}
checkCode.value = code;//把code值赋给验证码
}

//校验验证码
function validate() {
  var inputCode = document.getElementById("input").value.toUpperCase(); //取得输入的验证码并转化为大写
  if (inputCode.length <= 0) { //若输入的验证码长度为0
    alert("请输入验证码！"); //则弹出请输入验证码
  }
  else if (inputCode != code) { //若输入的验证码与产生的验证码不一致时
    alert("验证码输入错误！"); //则弹出验证码输入错误
    createCode();//刷新验证码
    document.getElementById("input").value = "";//清空文本框
  }
  else { //输入正确时
    alert("正确!"); //弹出正确
  }
}
*/

//shiro Login
// function shiroLogin() {
//   var adminName = $('#loginInputName').val();
//   var adminPassword = $('#loginInputPassword').val();
//   console.log(adminPassword)
//   $.ajax({
//     url:'/adminLogin',
//     type:'post',
//     async:true,
//     data:{
//       adminName:adminName,
//       adminPassword:adminPassword
//     },
//     success:function () {
//
//     }
//   })
// }