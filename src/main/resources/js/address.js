$("#userInfo").attr("href", "/user/" + localStorage.getItem("userId"));
$("#payOrder").attr("href", "/order/query?s=1&u=" + localStorage.getItem("userId"));

/*--------------------------------------新增用户地址---------------------------------------*/
$(function () {
    var addrInfoSaveButton = $("#addrInfoSaveButton");
    var contactsName = $("#contactsName");
    var contactsTel = $("#contactsTel");
    var Address = $("#Address");

    addrInfoSaveButton.on("click", function () {
        var form = new FormData();
        form.append("contactsName", contactsName.val());
        form.append("tel", contactsTel.val());
        form.append("companyAddr", Address.val());
        $.ajax({
            url: '/address',
            type: 'post',
            data: form,
            processData: false,
            contentType: false,
            success: function (response) {
                if (response.state === 0) {
                    alert("保存成功");
                    window.location.reload();
                } else {
                    alert("保存失败");
                }
            }
        });
    });
});

/*--------------------------------------修改用户地址---------------------------------------*/
var addressId;
$(function () {
    var modifyAddrInfo = $(".modifyAddrInfo");
    modifyAddrInfo.on("click", function () {

        addressId = $(this).parent().find(".addressId").html();
        var ContactsName = $(this).parent().find(".user").html();
        var contactsTel = $(this).parent().find(".phone").html();
        var address = $(this).parent().find(".room").html();

        $("#modifyContactsName").val(ContactsName);
        $("#modifyContactsTel").val(contactsTel);
        $("#modifyAddress").val(address);
    });
});

$(function () {
    var modifyAddrInfoButton = $("#modifyAddrInfoButton");
    var modifyContactsName = $("#modifyContactsName");
    var modifyContactsGender = $("#modifyContactsGender");
    var modifyContactsTel = $("#modifyContactsTel");
    var modifyAddress = $("#modifyAddress");

    modifyAddrInfoButton.on("click", function () {
        var form = new FormData();
        form.append("id", addressId);
        form.append("contactsName", modifyContactsName.val());
        form.append("tel", modifyContactsTel.val());
        form.append("companyAddr", modifyAddress.val());
        $.ajax({
            url: '/modifyAddress',
            type: 'post',
            data: form,
            processData: false,
            contentType: false,
            success: function (response) {
                if (response.state === 0) {
                    alert("保存成功");
                } else {
                    alert("保存失败");
                }
            }
        });
    });
});

$(function () {
  var userAddrDeleteButton = $("#userAddrDeleteButton");

  userAddrDeleteButton.on("click", function () {
    var form = new FormData();
    form.append("id", addressId);
    $.ajax({
      url: '/removeAddress',
      type: 'post',
      data: form,
      processData: false,
      contentType: false,
      success: function (response) {
        if (response.state == 0) {
          alert("删除成功");
          window.location.reload();
        } else {
          alert("删除失败");
        }
      }
    });
  });
});


//删除地址弹框
$(".delete").click(function(){
  $("#MyDelete").show();
  $("#delete").show();
  addressId = $(this).parent().find(".addressId").html();
});
$(".yes, .no").click(function(){
  $("#MyDelete").hide();
  $("#delete").hide();
});
//新增地址弹框
$(".onShow").click(function () {
    $("#MyAdd").show();
    $("#fade1").show();
});
$(".onClose").click(function () {
    $("#MyAdd").hide();
    $("#fade1").hide();
});
//修改地址弹框
$(".alter").click(function () {
    $("#MyTake").show();
    $("#fade2").show();
});
$(".close").click(function () {
    $("#MyTake").hide();
    $("#fade2").hide();
});

$("#userInfo").attr("href", /user/ + localStorage.getItem("userId"));


