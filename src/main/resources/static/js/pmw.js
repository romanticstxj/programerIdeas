$("#btnSubmitCreatePayment").click(function () {
    $.ajax({
        cache: true,
        type: "POST",
        url: "http://localhost:8090/mockpis/transactions/combined",
        data: $("#txtCreatePaymentJson").val(),
        async: false,
        contentType: "application/json",
        headers: {
            "Accept-Language": "en",
            //"X-CIP" : "10.131.246.128",
            "Authorization": "BEARER RxJJY07kNINxiIJ0kJMt3y"
            //"X-Disney-Internal-SHDR-APIM" : true
        },
        dataType: "json",
        error: function (request) {
            alert(request.responseText);
        },
        success: function (data) {
            var formHTML = "<form target='_blank' id='wechatpayForm' method='" + data.body.redirectInfo.method + "' action='" + data.body.redirectInfo.href + "'>";
            var htmlText = "";
            $.each(data.body.redirectInfo.params,
                function (key, val) {
                    formHTML += "<input type='hidden' name='" + key + "' value='" + val + "'/>";
                });
            formHTML += "</form>";
            $("#wechatpayFormDiv").html(formHTML);
            $("#wechatpayForm").submit();
        }
    });
});

$("#btnGenerateQRCode").click(function () {
    makeCode();
});

var qrcode = new QRCode(document.getElementById("qrcode"), {
    width: 200,
    height: 200
});

function makeCode() {
    var elText = document.getElementById("text");

    if (!elText.value) {
        alert("Input a text");
        elText.focus();
        return;
    }

    qrcode.makeCode(elText.value);
}