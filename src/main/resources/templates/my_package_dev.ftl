<div class="Pack"></div>
<div class="MyPack">
    <div class="pack">
        <div class="cont-box">
            <span class="onClose">×</span>
            <h2>审核套餐内容</h2>
            <div class="cont">
                <input class="goodId" id="goodId" type="hidden" value="${good.id}"/>
                <p class="classify">分类: <span>生日聚会</span>><span>蛋糕组合</span></p>
                <p class="ground">上架数量: <span>99</span></p>
                <p class="budget">适合人数: <span>8人</span></p>
                <p class="title-pack">
                    <span>激爽夏日可乐聚会套餐</span>
                    <span class="pri">套餐价:<i>￥</i><strong>148</strong></span>
                </p>
                <ul class="upload-img">
                <#assign text>${good.pictureUrl}</#assign>
                <#assign json=text?eval />
                <#list json as pictureUrl>
                    <li>
                        <img src="${pictureUrl}" alt=""/>
                    </li>
                </#list>
                </ul>
            </div>
            <table border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <th>商品名称</th>
                    <th>口味</th>
                    <th>份数</th>
                </tr>
            <#assign text>${good.content}</#assign>
            <#assign json=text?eval />
            <#list json as single>
                <tr>
                    <td>${single.title}</td>
                    <td>${single.taste}</td>
                    <td>${single.count}份</td>
                </tr>
            </#list>
            </table>
        <textarea readonly="readonly" class="remarks">${good.description}</textarea>
        <textarea readonly="readonly" class="mark">${good.specification}</textarea>
        </div>
        <div class="btn-box">
            <div class="btn">
                <button class="pass" type="button" onclick="">上架</button>
                <button class="not" type="button">删除套餐</button>
            </div>
        </div>
    </div>
</div>