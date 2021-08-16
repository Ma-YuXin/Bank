window.onload = function () {
    bankcard();
    historyBill()
}

function bankcard() {
    //  $("[name='bankCardList']").empty();
    $.ajax({
            url: '/bankCardList', //请求的url
            type: 'post', //请求的方式
            //form表单里要提交的内容，里面的input等写上name就会提交，这是序列化
            dataType: "json",
            error: function (data) {
                alert('银行卡列表请求失败');
            },
            success: function (data) {
                // console.log(data);
                let stringOfId;
                $("#bankCardList").empty();
                $("#bankCardListDeposit").empty();
                $("#bankCardListWithdraw").empty();
                $("#bankCardListTransfer").empty();
                for (var i = 0; i < data.length; i++) {
                    let str = "<div class=\"row\">" +
                        "<div class =\"col-xs-2\">" + data[i].userName + "</div>" +
                        "<div class =\"col-xs-2\">" + data[i].bank + "</div>" +
                        "<div class =\"col-xs-2\">" + data[i].bankCardNumber + "</div>" +
                        "<div class =\"col-xs-2\">" + data[i].userId + "</div>" +
                        "<div class =\"col-xs-2\">" + data[i].remainingBalance + "</div>" +
                        "<div class=\"col-xs-2\">";
                    $("#bankCardManageList").append(str +
                        "<button class=\"btn" + " " + "btn-success" + " " + "btn-xs\" data-target = \"#modifyBankCard\" data-toggle = \"modal\">" +
                        "修改" +
                        "</button>" +
                        "<button class = \"btn" + " " + "btn-danger" + " " + "btn-xs\" data-target = \"#deleteBankCard\" data-toggle = \"modal\" >" +
                        "删除" +
                        "</button>" +
                        "</div>" +
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

function historyBill() {
    $.ajax({
        url: '/historyBillList',
        data: {},
        dataType: 'json',
        type: 'get',
        error: function (data) {
            alert("历史账单记录查询失败！！！")
        },
        success: function (data) {
            // console.log(data);
            $("#historyBillList").empty();
            for (var i = 0; i < data.length; i++) {
                let str = "<div class=\"row\">" +
                    "<div class =\"col-xs-2\">" + data[i].type + "</div>" +
                    "<div class =\"col-xs-1\">" + data[i].senderName + "</div>" +
                    "<div class =\"col-xs-2\">" + data[i].sender + "</div>" +
                    "<div class =\"col-xs-1\">" + data[i].payeeName + "</div>" +
                    "<div class =\"col-xs-2\">" + data[i].payee + "</div>" +
                    "<div class =\"col-xs-2\">" + data[i].value + "</div>" +
                    "<div class=\"col-xs-1\">" +
                    "<button class=\"btn" + " " + "btn-danger" + " " + "btn-xs\" data-target = \"#deleteHistory\" data-toggle = \"modal\">" +
                    "删除记录" +
                    "</button>" +
                    "</div>" +
                    "</div>";
                $("#historyBillList").append(str);
            }


        }
    });
}

function changeSingle() {
    const changeSingleValue = document.getElementById("changeSingleValue").value;
    if (state == "name") {

        $.ajax({
            url: '/changeNameSingle',
            data: {
                "newNameSingle": changeSingleValue
            },
            dataType: 'json',
            type: 'get',
            error: function (data) {
                alert("修改信息失败！！！")
            },
            success: function (data) {
                console.log(data);
                alert("修改信息成功")
            }
        });
    } else if (state == "address") {
        $.ajax({
            url: '/changeAddressSingle',
            data: {
                "newAddressSingle": changeSingleValue
            },
            dataType: 'json',
            type: 'get',
            error: function (data) {
                alert("修改信息失败！！！")
            },
            success: function (data) {
                console.log(data);
                alert("修改信息成功")
            }
        });
    } else if (state == "phoneNumber") {
        $.ajax({
            url: '/changeTelephoneNumberSingle',
            data: {
                "newTelephoneNumberSingle": changeSingleValue
            },
            dataType: 'json',
            type: 'get',
            error: function (data) {
                alert("修改信息失败！！！")
            },
            success: function (data) {
                console.log(data);
                alert("修改信息成功")
            }
        });
    } else {
        alert("发生了一些未知错误");
    }
    document.getElementById("changeSingleValue").value = "";
}

function changeMultiple() {
    const newNameMultiple = document.getElementById("newNameMultiple").value;
    const newAddressMultiple = document.getElementById("newAddressMultiple").value;
    const newTelephoneNumberMultiple = document.getElementById("newTelephoneNumberMultiple").value;
    $.ajax({
        url: '/changeMultiple',
        data: {
            "newNameMultiple": newNameMultiple,
            "newAddressMultiple": newAddressMultiple,
            "newTelephoneNumberMultiple": newTelephoneNumberMultiple
        },
        dataType: 'json',
        type: 'get',
        error: function (data) {
            alert("修改多项信息失败！！！")
        },
        success: function (data) {
            console.log(data);
            alert("修改多项信息成功")
        }
    });
}

function changePassword() {

    const oldPassword = document.getElementById("oldPassword").value;
    console.log("旧密码为" + oldPassword);
    const newPassword = document.getElementById("newPassword").value;
    const repeatPassword = document.getElementById("repeatPassword").value;

    if (newPassword == repeatPassword) {
        $.ajax({
            url: '/changePassword',
            data: {
                "oldPassword": oldPassword,
                "newPassword": newPassword,
                "repeatPassword": repeatPassword
            },
            dataType: 'json',
            type: 'get',
            error: function (data) {
                alert("修改密码失败！！！")
            },
            success: function (data) {
                console.log(data);
                alert("修改密码成功")
            }
        });
    } else {
        alert("两次密码不一致");
    }
}
