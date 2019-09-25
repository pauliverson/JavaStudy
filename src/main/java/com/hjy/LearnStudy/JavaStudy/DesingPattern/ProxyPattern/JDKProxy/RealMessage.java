package com.hjy.LearnStudy.JavaStudy.DesingPattern.ProxyPattern.JDKProxy;

/**
 * @author huangjunyan
 * @date 2019-07-02 11:32
 */
public class RealMessage implements Message {
    @Override
    public String sendMessage() {
        System.out.println("发送信息");
        return "信息";
    }

    @Override
    public int sendNumber() {
        System.out.println("发送电话");
        return 123;
    }
}
