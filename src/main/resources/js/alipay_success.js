var orderNum = getUrlParam("out_trade_no");
alert(orderNum);

function getUrlParam(name) {
  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if (r) return unescape(r[2]); return null;
}

