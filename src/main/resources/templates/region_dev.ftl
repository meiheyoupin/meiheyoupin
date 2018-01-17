<select class="provinceId" style="width:100px;float:left" alt="..." onclick="selRegion(0)" name="provinceId" id="provinceId">
  <option>--请选择省--</option>
  #foreach($item in $provinceList)
  <option value="$item.regionId">$item.regionName</option>
  #end
</select>
<select class="cityId" style="width:100px; float:left" onclick="selRegion(1)" id="cityId" name="cityId">
  <option>--请选择市--</option>
</select>
<select class="regionId" style="width:100px; float:left" onclick="selRegion(2)" id="regionId" name="regionId">
  <option>--请选择区--</option>
</select>