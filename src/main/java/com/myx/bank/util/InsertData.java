package com.myx.bank.util;

import com.myx.bank.pojo.Bank;
import com.myx.bank.pojo.BussinessType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class InsertData {

    //启动所有写入文件方法
    public void insertIntoDatabase() throws IOException {
        insertIntoUser();
        insertIntoBill();
        insertIntoBankcardAndUserBandcard();
    }

    //向insertIntoUser.sql写入user表的插入语句
    public void insertIntoUser() throws IOException {
        File file = new File(CommonVariables.sqlFilePath + "insertData.sql");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            for (int i = 100; i < 150; i++) {
                String id = String.valueOf(i);
                String insertWords = "insert into user(id,password) values(" + id + ",\"" + id + "\");\r\n";
                bufferedWriter.write(insertWords);
                bufferedWriter.flush();
            }
            System.out.println("成功插入向insertData.sql文件写入id和密码都为100到150的用户的插入语句");
        } finally {
            fileWriter.close();
            bufferedWriter.close();
        }
    }

    //向insertIntoBill.sql文件写入向Bill表的插入语句
    public void insertIntoBill() throws IOException {
        File file = new File(CommonVariables.sqlFilePath + "insertData.sql");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Random random = new Random();
        try {
            for (int i = 100; i < 150; i++) {
                String senderID = String.valueOf(i);
                for (int t = 0; t < random.nextInt(15); t++) {
                    String payeeID = String.valueOf(random.nextInt(49) + 100);
                    String value = String.valueOf(random.nextDouble() * 1000000);
                    BussinessType type = BussinessType.getRandomly();
                    String insertWords = null;
                    if (type == BussinessType.取款) {
                        insertWords = "insert into bill(sender,value,type) values(" + senderID + "," + value + ",\"" + type + "\");\r\n";
                    }
                    if (type == BussinessType.存款) {
                        insertWords = "insert into bill(payee,value,type) values(" + payeeID + "," + value + ",\"" + type + "\");\r\n";
                    }
                    if (type == BussinessType.转账) {
                        insertWords = "insert into bill(sender,payee,value,type) values(" + senderID + "," + payeeID + "," + value + ",\"" + type + "\");\r\n";
                    }
                    if (type == BussinessType.贷款) {
                        insertWords = "insert into bill(payee,value,type) values(" + "," + payeeID + "," + value + ",\"" + type + "\");\r\n";
                    }
                    bufferedWriter.write(insertWords);
                    bufferedWriter.flush();

                }
            }
            System.out.println("成功插入向insertData.sql文件写入向Order表的插入语句");
        } finally {
            fileWriter.close();
            bufferedWriter.close();
        }
    }

    //向insertIntoBankcardAndUserBandcard.sql文件写入向BankCard和UserBankCard表的插入语句
    public void insertIntoBankcardAndUserBandcard() throws IOException {
        File file = new File(CommonVariables.sqlFilePath + "insertData.sql");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Random random = new Random();
        try {
            for (int i = 100; i < 150; i++) {
                for (int t = 0; t < random.nextInt(10); t++) {
                    String bankCardNumber = String.valueOf(random.nextInt(1000000000) + 100000000);
                    Bank bankName = Bank.getRandomly();
                    String insertWord = "insert into BANKCARD(BANKCARDNUMBER,PASSWORD,BANK_NAME) values(" + bankCardNumber + ",111111,\"" + bankName + "\");\r\n";
                    bufferedWriter.write(insertWord);
                    String userID = String.valueOf(i);
                    String insertWord2 = "insert into USER_BANKCARD(USERID,BANKCARDNUMBER) values(" + userID + "," + bankCardNumber + ");\r\n";
                    bufferedWriter.write(insertWord2);
                    bufferedWriter.flush();
                }
            }
            System.out.println("向insertData.sql文件写入向BankCard和UserBankCard表的插入语句成功");
        } finally {
            fileWriter.close();
            bufferedWriter.close();
        }
    }
}
