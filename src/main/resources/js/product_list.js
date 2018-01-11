$(function () {

    function UpdateUrlParam(url, name, value) {
        var r = url;
        if (r) {
            value = encodeURIComponent(value);
            var reg = new RegExp("(^|)" + name + "=([^&]*)(|$)");
            var tmp = name + "=" + value;
            if (url.match(reg)) {
                r = url.replace(eval(reg), tmp);
            }
            else {
                if (url.match("[\?]")) {
                    r = url + "&" + tmp;
                } else {
                    r = url + "?" + tmp;
                }
            }
        }
        return r;
    }

    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r) return unescape(r[2]);
        return null;
    }

    $(".menu-rt div a").click(function () {
        var value = $(this).html().replace("人", "");
        if (value === "更多") {
            value = "-1";
        }
        window.location.href = UpdateUrlParam(window.location.href, "np", value);

    });

    $(".menu-less a").each(function (i) {
        $(this).click(function () {
            window.location.href = UpdateUrlParam(window.location.href, "ob", i + 1);
        })
    });

    //点击加载更多
    var page = 2;
    var productListUl = $("#productList");
    var loadMoreButton = $("#loadMore");
    loadMoreButton.on("click", function (event) {
        event.preventDefault();
        var formData = new FormData();
        formData.append("page", page);
        formData.append("cate", getUrlParam("cate"));
        formData.append("subj", getUrlParam("subj"));
        formData.append("np", getUrlParam("np"));
        formData.append("ob", getUrlParam("ob"));
        $.ajax({
            url: "/product/list",
            type: "post",
            data: formData,
            processData: false,
            contentType: false,
            success: function (response) {
                if (response.state === 0) {
                    var html = template("goodsListTemplate", response.data);
                    productListUl.append($(html));
                    page += 1;
                } else {
                    alert("出现了错误...");
                }
            }
        });

    });

    for (let i = 0; i < 999; i++) {
        $(".border").eq(i).hover(function () {
            $('.border').eq(i).fadeIn(500).css({'border-color': '#FED500'});
        }, function () {
            $('.border').eq(i).fadeIn(500).css({'border-color': 'transparent'});
        });
    }
});
