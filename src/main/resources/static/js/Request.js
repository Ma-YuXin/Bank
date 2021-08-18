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
                        "<button class=\"btn" + " " + "btn-success" + " " + "btn-xs\" onclick=\"getBankcardNumber(this)\"  data-target = \"#modifyBankCard\" data-toggle = \"modal\">" +
                        "修改" +
                        "</button>" +
                        "<button class = \"btn" + " " + "btn-danger" + " " + "btn-xs\" onclick=\"getBankcardNumber(this)\" data-target = \"#deleteBankCard\" data-toggle = \"modal\" >" +
                        "删除" +
                        "</button>" +
                        "</div>" +
                        "</div>");

                    $("#bankCardListDeposit").append(str +
                        "<button class=\"btn" + " " + "btn-success" + " " + "btn-xs\" onclick=\"getBankcardNumber(this)\" data-target = \"#reviseSchool\" data-toggle = \"modal\">" +
                        "存款" +
                        "</button>" + "</div>" +
                        "</div>");

                    $("#bankCardListWithdraw").append(str +
                        "<button class=\"btn" + " " + "btn-success" + " " + "btn-xs\" onclick=\"getBankcardNumber(this)\"  data-target = \"#withdrawMoney\" data-toggle = \"modal\">" +
                        "取款" +
                        "</button>" + "</div>" +
                        "</div>");

                    $("#bankCardListTransfer").append(str +
                        "<button class=\"btn" + " " + "btn-success" + " " + "btn-xs\" onclick=\"getBankcardNumber(this)\"  data-target = \"#transferDetial\" data-toggle = \"modal\">" +
                        "转账" +
                        "</button>" + "</div>" +
                        "</div>");
                }
            }
        }
    );
}


function getBankcardNumber(obj) {
    window.bankcardManageNumber = obj.parentNode.parentNode.children.item(2).textContent;
    // console.log(window.bankcardManageNumber + " 4");
    window.remainingBalance = obj.parentNode.parentNode.children.item(4).textContent;
}

function getBillInformation(param) {
    window.billBalance = param.parentNode.parentNode.children.item(5).textContent;
    window.billType = param.parentNode.parentNode.children.item(0).textContent;
    console.log(billBalance + " " + billType);
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
                    "<button class=\"btn" + " " + "btn-danger" + " " + "btn-xs\" onclick=\"getBillInformation(this)\" data-target = \"#deleteHistory\" data-toggle = \"modal\">" +
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


    if (state === "name") {
        console.log("进入修改姓名模块");
        $.ajax({
            url: '/changeNameSingle',
            data: {
                "newNameSingle": changeSingleValue
            },
            dataType: 'text',
            type: 'get',
            error: function (data) {
                alert("修改姓名失败！！！")
            },
            success: function (data) {
                console.log(data);
                alert("修改姓名成功")
            }
        });
    } else if (state === "address") {
        console.log("进入修改地址模块");
        $.ajax({
            url: '/changeAddressSingle',
            data: {
                "newAddressSingle": changeSingleValue
            },
            dataType: 'text',
            type: 'get',
            error: function (data) {
                alert("修改地址失败！！！")
            },
            success: function (data) {
                console.log(data);
                alert("修改地址成功")
            }
        });
    } else if (state === "phoneNumber") {
        console.log("进入修改电话模块");
        $.ajax({
            url: '/changeTelephoneNumberSingle',
            data: {
                "newTelephoneNumberSingle": changeSingleValue
            },
            dataType: 'text',
            type: 'get',
            error: function (data) {
                alert("修改电话号码失败！！！")
            },
            success: function (data) {
                console.log(data);
                alert("修改电话号码成功")
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
        dataType: 'text',
        type: 'get',
        error: function (data) {
            console.log(data);
            alert("修改多项信息失败！！！")
        },
        success: function (data) {
            console.log(data);
            alert("修改多项信息成功")
        }
    });
    document.getElementById("changeSingleValue").style.display = "false";
}

function changePassword() {

    const oldPassword = document.getElementById("oldPassword").value;
    console.log("旧密码为" + oldPassword);
    const newPassword = document.getElementById("newPassword").value;
    const repeatPassword = document.getElementById("repeatPassword").value;

    if (newPassword === repeatPassword) {
        $.ajax({
            url: '/changePassword',
            data: {
                "oldPassword": oldPassword,
                "newPassword": newPassword,
                "repeatPassword": repeatPassword
            },
            dataType: 'text',
            type: 'get',
            error: function (data) {
                alert("修改密码失败！！！")
                console.log(data);
            },
            success: function (data) {
                console.log(data);
                alert("修改密码成功")
            }
        });
    } else {
        alert("两次密码不一致");
        document.getElementById("newPassword").value = "";
        document.getElementById("repeatPassword").value = "";
    }
}

function changeBankcardPassword() {
    const newPassword = document.getElementById("modifyBankCardPassword").value;
    const repeatPassword = document.getElementById("modifyRepeatBankCardPassword").value;

    if (newPassword === repeatPassword) {
        $.ajax({
            url: '/changeBankcardPassword',
            data: {
                "bankcardNumber": window.bankcardManageNumber,
                "newPassword": newPassword,
                "repeatPassword": repeatPassword
            },
            dataType: 'text',
            type: 'get',
            error: function (data) {
                alert("修改卡号为" + window.bankcardManageNumber + "密码失败！！！")
                console.log(data);
            },
            success: function (data) {
                console.log(data);
                alert("修改卡号为" + window.bankcardManageNumber + "密码成功")
            }
        });
    } else {
        alert("两次密码不一致");
        document.getElementById("modifyBankCardPassword").value = "";
        document.getElementById("modifyRepeatBankCardPassword").value = "";
    }
}

function deleteBankcard() {
    $.ajax({
        url: '/deleteBankcard',
        data: {
            "bankcardNumber": window.bankcardManageNumber
        },
        dataType: 'text',
        type: 'get',
        error: function (data) {
            alert("删除卡号为" + window.bankcardManageNumber + "的银行卡失败！！！")
            console.log(data);
        },
        success: function (data) {
            console.log(data);
            alert("删除卡号为" + window.bankcardManageNumber + "的银行卡成功")
        }
    });
}

function depositMoney() {
    const number = document.getElementById("depositNumber").value;
    $.ajax({
        url: '/depositMoney',
        data: {
            "bankcardNumber": window.bankcardManageNumber,
            "number": number
        },
        dataType: 'text',
        type: 'get',
        error: function (data) {
            alert("向卡号为" + window.bankcardManageNumber + "的银行卡存款失败！！！")
            console.log(data);
        },
        success: function (data) {
            console.log(data);
            alert("成功向卡号为" + window.bankcardManageNumber + "的银行卡存入" + number + "元")
        }
    });
}

function withdrawMoney(obj) {
    const number = document.getElementById("withdrawNumber").value;
    if (parseFloat(window.remainingBalance) >= parseFloat(number)) {
        $.ajax({
            url: '/withdrawNumber',
            data: {
                "bankcardNumber": window.bankcardManageNumber,
                "number": number
            },
            dataType: 'text',
            type: 'get',
            error: function (data) {
                alert("向卡号为" + window.bankcardManageNumber + "的银行卡取款失败！！！")
                console.log(data);
            },
            success: function (data) {
                console.log(data);
                alert("成功从卡号为" + window.bankcardManageNumber + "的银行卡取出" + number + "元")
            }
        });
    } else {
        alert("余额不足！！");
    }

}

function deleteHistoryBill() {
    $.ajax({
        url: '/deleteHistoryBill',
        data: {
            "balance": window.billBalance,
            "type": window.billType
        },
        dataType: 'text',
        type: 'get',
        error: function (data) {
            alert("删除订单失败！！！")
            console.log(data);
        },
        success: function (data) {
            console.log(data);
            alert("删除订单成功！！！")
        }
    });
}

function transferMoney() {
    const transferNumber = document.getElementById("transferNumber").value;
    const receiverBankCardNumber = document.getElementById("receiverBankCardNumber").value;
    $.ajax({
        url: '/transferMoney',
        data: {
            "sender": window.bankcardManageNumber,
            "money": transferNumber,
            "payee": receiverBankCardNumber
        },
        dataType: "text",
        type: "get",
        error: function (data) {
            console.log(data);
            alert("转账失败");
        },
        success: function (data) {
            console.log(data);
            alert("转账成功");
        }
    });
}