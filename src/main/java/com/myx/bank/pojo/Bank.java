package com.myx.bank.pojo;

import java.util.Random;

/**
 * description: Bank <br>
 * date: 2021/8/6 22:17 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public enum Bank {
    中国银行,
    建设银行,
    工商银行;

    public static Bank getRandomly() {
        Random random = new Random();
        return Bank.values()[random.nextInt(Bank.values().length)];
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
