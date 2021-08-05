package com.myx.pojo;

import java.util.Random;

public enum BussinessType {
    存款, 取款, 转账, 贷款;

    @Override
    public String toString() {
        return super.toString();
    }

    public static BussinessType getRandomly() {
        Random random=new Random();
        return BussinessType.values()[random.nextInt(Bank.values().length)];
    }
}
