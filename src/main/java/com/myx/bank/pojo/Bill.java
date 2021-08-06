package com.myx.bank.pojo;

public class Bill {
    private int SENDER;
    private int PAYEE;
    private double VALUE;
    private String type;

    public Bill() {
    }

    public Bill(int SENDER, int PAYEE, double VALUE, String type) {
        this.SENDER = SENDER;
        this.PAYEE = PAYEE;
        this.VALUE = VALUE;
        this.type = type;
    }


    public int getSENDER() {
        return SENDER;
    }

    public void setSENDER(int SENDER) {
        this.SENDER = SENDER;
    }

    public int getPAYEE() {
        return PAYEE;
    }

    public void setPAYEE(int PAYEE) {
        this.PAYEE = PAYEE;
    }

    public double getVALUE() {
        return VALUE;
    }

    public void setVALUE(double VALUE) {
        this.VALUE = VALUE;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Bill{" +
                "SENDER=" + SENDER +
                ", PAYEE=" + PAYEE +
                ", VALUE=" + VALUE +
                ", type='" + type + '\'' +
                '}';
    }
}
