package com.welleys.stu.pattern.factory.method;

/**
 * @author suzw1
 * @date 2018/07/11
 */
public class SmsSender implements Sender {
    public void send() {
        System.out.println("sms has been sent");
    }
}
