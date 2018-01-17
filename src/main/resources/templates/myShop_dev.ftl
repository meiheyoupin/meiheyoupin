<div class="Shop"></div>
<div class="MyShop">
    <div class="check_add">
        <div class="cont-box">
            <span class="onClose">×</span>
            <h2>审核商品信息</h2>
            <div class="cont_lf">
                <input class="goodId" id="goodId" type="hidden" value="${good.id}"/>
                <p class="shop-lf-title">
                    <span>${good.content}</span>
                </p>
                <p class="shop-lf-img">
                    <img src="${good.pictureUrl}" alt="" />
                </p>
                <p class="shop-lf-depict">
                    <textarea readonly="readonly" placeholder="描述一下你的商品...">${good.content}</textarea>
                </p>
            </div>
            <div class="cont_rt">
                <p class="shop-rt-price">
                    单价:<span>￥</span><strong>${good.price}</strong>
                </p>
                <p class="shop-rt-img">
                    <img src="${good.primaryPictureUrl}" alt="" />
                </p>
            </div>
        </div>
        <div class="btn-box">
            <div class="btn">
                <button class="pass" type="button" onclick="auditGood()">审核通过</button>
                <button class="not" type="button">审核未通过</button>
            </div>
        </div>
    </div>
</div>