<div class="Pack"></div>
<div class="MyPack">
    <div class="pack">
        <div class="cont-box">
            <span class="onClose">×</span>
            <h2>审核套餐内容</h2>
            <div class="cont">
                <input class="goodId" id="goodId" type="hidden" value="${good.good.id}"/>
                <p class="classify">分类: <span>${good.subject.name}</span>><span>${good.category.name}</span></p>
                <p class="appo">预约天数: <span>
                <#if good.good.appointment??>
                    <#assign a=86400000 />
                    ${good.good.appointment?number / a}
                <#else>
                    不预约
                </#if>
                </span></p>
                <p class="ground">上架数量: <span>
                <#if good.good.limitCount??>
                ${good.good.limitCount}
                <#else>
                    不限
                </#if>
                </span></p>
                <p class="budget">适合人数: <span>${good.good.numOfPeople}人</span></p>
                <p class="title-pack">
                    <span>${good.good.name}</span>
                    <span class="pri">套餐价:<i>￥</i><strong>${good.good.price}</strong></span>
                </p>
                <ul class="upload-img">
                <#assign text>${good.good.pictureUrl}</#assign>
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
            <#assign text>${good.good.content}</#assign>
            <#assign json=text?eval />
            <#list json as single>
                <tr>
                    <td>${single.title}</td>
                    <td>${single.taste}</td>
                    <td>${single.count}份</td>
                </tr>
            </#list>
            </table>
            <textarea readonly="readonly" class="remarks">${good.good.description}</textarea>
        </div>
        <div class="btn-box">
            <div class="btn">
                <button class="via" type="button" onclick="auditGood(${good.good.id?c})">审核通过</button>
                <button class="no" type="button">审核未通过</button>
            </div>
        </div>
    </div>
</div>