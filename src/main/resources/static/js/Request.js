function bankcard() {
    //  $("[name='bankCardList']").empty();
    $.ajax({
            url: 'http://localhost:8080/bankCardList', //请求的url
            type: 'post', //请求的方式
            //form表单里要提交的内容，里面的input等写上name就会提交，这是序列化
            dataType: "json",
            error: function (data) {
                alert('请求失败');
            },
            success: function (data) {
                console.log(data);
                let stringOfId;
                for (var i = 0; i < data.length; i++) {
                    let str = "<div class=\"row\">" +
                        "<div class =\"col-xs-2\">" + data[i].userName + "</div>" +
                        "<div class =\"col-xs-2\">" + data[i].bank + "</div>" +
                        "<div class =\"col-xs-2\">" + data[i].bankCardNumber + "</div>" +
                        "<div class =\"col-xs-2\">" + data[i].userId + "</div>" +
                        "<div class =\"col-xs-2\">" + data[i].remainingBalance + "</div>" +
                        "<div class=\"col-xs-2\">";

                    $("#bankCardList").append(str + "<button class=\"btn" + " " + "btn-success" + " " + "btn-xs\" data-target = \"#modifyBankCard\" data-toggle = \"modal\">" +
                        "修改" +
                        "</button>" +
                        "<button class = \"btn" + " " + "btn-danger" + " " + "btn-xs\" data-target = \"#deleteBankCard\" data-toggle = \"modal\" >" +
                        "删除" +
                        "</button>" + "</div>" +
                        "</div>");
                    $("#bankCardListDeposit").append(str +
                        "<button class=\"btn" + " " + "btn-success" + " " + "btn-xs\" data-target = \"#reviseSchool\" data-toggle = \"modal\">" +
                        "存款" +
                        "</button>" + "</div>" +
                        "</div>");
                    $("#bankCardListWithdraw").append(str +
                        "<button class=\"btn" + " " + "btn-success" + " " + "btn-xs\" data-target = \"#withdrawMoney\" data-toggle = \"modal\">" +
                        "取款" +
                        "</button>" + "</div>" +
                        "</div>");
                    $("#bankCardListTransfer").append(str +
                        "<button class=\"btn" + " " + "btn-success" + " " + "btn-xs\" data-target = \"#transferDetial\" data-toggle = \"modal\">" +
                        "转账" +
                        "</button>" + "</div>" +
                        "</div>");
                }
            }
        }
    )
    ;
}

window.onload = function () {
    bankcard();
}