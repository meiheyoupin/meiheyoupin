//下架套餐
function downGoods() {
  var arr = document.getElementsByName("good");
  var goodIds=[];
  for (i=0;i<arr.length;i++){
    if (arr[i].checked)
      goodIds.push(arr[i].value);
  }
  console.log(goodIds);

  $.ajax({
    url:"platform/downGoods",
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
      window.location.href='/cpyShop';
    }
  })
}

//上架套餐
function upGoods() {
  var arr = document.getElementsByName("good");
  var goodIds=[];
  for (i=0;i<arr.length;i++){
    if (arr[i].checked)
      goodIds.push(arr[i].value);
  }
  console.log(goodIds);

  $.ajax({
    url:"platform/upGoods",
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
      window.location.href='/cpyShop';
    }
  })
}
