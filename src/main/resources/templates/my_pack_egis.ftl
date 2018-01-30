<!--审核通过弹框-->
<div class="pass"></div>
<div class="MyPass">
    <div class="move">
        <div class="title">
            <img src="/img/complete.png" alt="" />
        </div>
    </div>
    <div class="list">
        <p>已通过!</p>
        <p>稍后将自动发送信息到商家...</p>
    </div>
    <a class="back" href="javascript:;">×</a>
</div>
<!--审核未通过弹框-->
<div class="not"></div>
<div class="MyNot">
    <div class="move">
        <div class="title">
            <span>填写原因</span>
        </div>
    </div>
    <div class="list">
        <ul>
            <li><input name="reason" type="checkbox" value="套餐名违规"/>套餐名违规</li>
            <li><input name="reason" type="checkbox" value="价格不合理"/>价格不合理</li>
            <li><input name="reason" type="checkbox" value="套餐搭配不完善"/>套餐搭配不完善</li>
            <li><input name="reason" type="checkbox" value="套餐描述违规"/>套餐描述违规</li>
            <li class="last-item">
                <input type="checkbox"/>
                <span>其他</span><textarea class="other"></textarea>
            </li>
        </ul>
        <div class="btn-send"><a onclick="unsanctionedGood(${good.good.id?c})">发送</a></div>
        <div class="btn-back"><a href="javascript:;">返回</a></div>
    </div>
</div>