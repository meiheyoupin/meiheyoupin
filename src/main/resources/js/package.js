/**
 * Created by 123 on 2018/1/27.
 */
$(function () {
   $.ajax({
       url:'/goods',
       type:'get',
       data:{
           goodIds:goodIds
       },
       success:function (data) {
           if (data.code==200){
               window.location.href='/cpyPackage';
           }else if (data.code==500){
               alert("服务器内部错误")
           }
       }
   })
});