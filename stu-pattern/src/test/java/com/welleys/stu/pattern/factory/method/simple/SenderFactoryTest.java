package com.welleys.stu.pattern.factory.method.simple;

import org.junit.Test;

/**
 * 简单工厂模式测试
 *
 * @author suzw1
 */
public class SenderFactoryTest {

    @Test
    public void newInstance() {
        send(SenderFactory.MAIL);
        send(SenderFactory.SMS);
    }

    private void send(String targetSent) {
        Sender sender = SenderFactory.newInstance(targetSent);
        if (null != sender) {
            sender.send();
        }
    }
}
