$(function () {

  $.ajax({
    url:'salers',
    type:'get',
    dataType:'json',
    success:function (data) {
      if (data.code==200){

      }else if (data.code==500){
        alert("获取销售员列表失败");
      }
    }
  });

})
