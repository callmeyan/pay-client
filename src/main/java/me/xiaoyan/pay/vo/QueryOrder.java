package me.xiaoyan.pay.vo;

import java.io.Serializable;

public class QueryOrder implements Serializable {
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 魔法交易号
     */
    private String trade_no;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }
}
