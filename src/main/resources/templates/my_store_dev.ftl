<div class="Store">
    <div class="shop-name">
        <p class="title-shop">店铺名称</p>
        <p class="name-box">
            <span class="name1">${store.storeName}</span>
            <span class="name2"> 账号: </span>
            <span class="name3">${store.tel}</span>
        </p>
    </div>
    <div class="shop-addr">
        <p class="title-shop">店铺地址</p>
        <p class="addr-box">
            <span class="addr1">${store.storeAddr}</span>
        </p>
    </div>
    <div class="shop-env">
        <p class="title-shop">店铺环境</p>
        <p class="env-shop">
            <img class="file-bg" src="${store.storeOutsidePhotoUrl}" alt="" />
            <img class="file-bg" src="${store.storeInsidePhotoUrl}" alt="" />
        </p>
    </div>
    <div class="shop-id">
        <p class="title-shop">法人身份证</p>
        <p class="id-shop">
            <img class="file-bg" src="${store.bossIdcardPhotoUrl}" alt="" />
            <img class="file-bg" src="${store.bossIdcardPhotoUrl}" alt="" />
        </p>
        <span>正面</span>
        <span>背面</span>
    </div>
    <div class="shop-license">
        <p class="title-shop">营业执照</p>
        <p class="license-shop">
            <img class="file-bg" src="${store.certificatePhotoUrl}" alt="" />
        </p>
    </div>
    <div class="shop-licence">
        <p class="title-shop">卫生许可证</p>
        <p class="licence-shop">
            <img class="file-bg" src="${store.storeLicencePhotoUrl}" alt="" />
        </p>
    </div>
    <div class="examine">
        <p>
            <button class="btn-pass" type="button" onclick="auditStore()">审核通过</button>
            <button class="btn-not" type="button">审核未通过</button>
        </p>
    </div>
    <span class="close">×</span>
</div>