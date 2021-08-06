package com.myx.bank.pojo;

/**
 * description: BussinessType <br>
 * date: 2021/8/6 22:19 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */

import java.util.Random;

public enum BussinessType {
    存款, 取款, 转账, 贷款;

    public static BussinessType getRandomly() {
        Random random = new Random();
        return BussinessType.values()[random.nextInt(Bank.values().length)];
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
