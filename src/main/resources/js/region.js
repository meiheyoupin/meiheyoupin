function selRegion(type){
  var regionId = '';

  if(type==0){
    regionId = $("#provinceId").val();
  } else if(type==1){
    regionId = $("#cityId").val();
  } else if(type==2){
    regionId = $("#regionId").val();
  } else return;
  $("#prodRegionId").val(regionId);
  if(regionId!=''){
    $.post("getChildRegionListInSite", {regionId:regionId},   function(data) {
      if(data.state == 1) {
        html = "";
        for(var i=0; i<data.regionList.length; i++){
          region = data.regionList[i];
          html += "<option value='" + region.regionId + "'>" + region.regionName + "</option>";
        }
        console.log(html);
        if(type==0){
          $("#cityId").html("<option>--请选择市--</option>" + html);
          $("#regionId").html("<option>--请选择区--</option>");
        } else if(type==1){
          $("#regionId").html("<option>--请选择区--</option>" + html);
        }
      }
    }, 'json');
  }
}