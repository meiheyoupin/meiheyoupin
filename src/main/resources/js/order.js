$(function () {
    var paymentAmountSpan = $("#paymentAmount");
    var redEnvelopeSelect = $("select[name=redEnvelope]");
    var couponSelect = $("select[name=coupon]");
    var originalAmount = paymentAmountSpan.html();
    var originalPrice = $(".list-price").html();

    function updateTotalAmount(goodsDiv) {
        var totalPriceSpan = goodsDiv.find("div .list-price");
        var count = goodsDiv.find("div div .quantity").val();
        if (!count) {
            count = 1;
            goodsDiv.find("div div .quantity").val(count);
        }
        var totalAmount = originalAmount * count;
        totalPriceSpan.html(totalAmount);

    }

    function updatePaymentAmount() {
        var redEnvelope = redEnvelopeSelect.val();
        var coupon = couponSelect.val();
        var paymentAmount = 0;

        var goodsDivList = $(".box-list");
        goodsDivList.each(function () {
            var totalPrice = $(this).find("div .list-price").html();
            paymentAmount += totalPrice;
        });
        if (redEnvelope) {
            paymentAmount -= redEnvelope;
        }
        if (coupon) {
            paymentAmount -= coupon;
        }
        paymentAmountSpan.html(paymentAmount);

    }

    redEnvelopeSelect.find("option").first().attr("selected", true);
    couponSelect.find("option").first().attr("selected", true);

    updatePaymentAmount();
    redEnvelopeSelect.on("change", function () {
        updatePaymentAmount();
    });
    couponSelect.on("change", function () {
        updatePaymentAmount();
    });

    $(".onBuy").on("click", function () {
        var form = new FormData();
        form.append("userId", localStorage.getItem("userId"));
        form.append("token", new Date().getTime());
        var goodsIdAndCountList = new Array();
        $(".box-list").each(function () {
            var id = $(this).find("div .list-id").html();
            var count = $(this).find("div div .quantity").val();
            if (id && count) {
                goodsIdAndCountList.push({"id": id, "count": count});
            }
        });
        form.append("goodsIdAndCountListJson", JSON.stringify(goodsIdAndCountList));
        var redEnvelope = redEnvelopeSelect.val() ? redEnvelopeSelect.val() : 0;
        form.append("redEnvelopeAmount", redEnvelope);
        var coupon = couponSelect.val() ? couponSelect.val() : 0;
        form.append("couponAmount", coupon);
        var comment = $("textarea[name=comment]").val();
        form.append("comment", comment);
        $.ajax({
            url: '/order',
            type: "post",
            data: form,
            processData: false,
            contentType: false,
            success: function (response) {
                if (response.state === 0) {
                    $.base64.utf8encode = true;
                    var orderId = $.base64.btoa(response.data.orderId);
                    var userId = $.base64.btoa((localStorage.getItem("userId")));// TODO
                    window.location.href = "/pay?o=" + orderId + "&u=" + userId;
                } else {
                    alert(response.message);
                }
            }
        });
    });

    $(".minus").on("click", function () {
        var count = $(this).siblings(".quantity").val();
        if (count > 1) {
            $(this).siblings(".quantity").val(--count)
            updateTotalAmount($(this).parent().parent().parent());
            updatePaymentAmount();
        }
    });
    $(".add").on("click", function () {
        var count = $(this).siblings(".quantity").val();
        $(this).siblings(".quantity").val(++count);
        updateTotalAmount($(this).parent().parent().parent());
        updatePaymentAmount();
    });
    $(".quantity").on("blur", function () {
        this.value = this.value.replace(/[^1-9]/g, '');
        updateTotalAmount($(this).parent().parent().parent());
        updatePaymentAmount();
    });


    $(".cout").click(function () {
        $(".addr-item:not(.active)").slideToggle();
    });
    $(".addr-item:first").addClass("active").slideToggle();
    $(".cout-on").click(function () {
        $(this).hide().siblings().show();
    });
    $(".cout-up").click(function () {
        $(this).hide().siblings().show();
    });

    for (let i = 0; i < 99; i++) {
        $(".addr-item").eq(i).click(function () {
            $('.addr-item').eq(i).addClass("active").siblings().removeClass("active");
        });
    }


});