package com.welleys.stu.pattern.factory.method.multi;

import org.junit.Test;

/**
 * {@link SendersFactory} test
 *
 * @author suzw1
 * @date 2018/07/11
 */
public class SendersFactoryTest {

    @Test
    public void mailSender() {
        SendersFactory.mailSender().send();
    }

    @Test
    public void smsSender() {
        SendersFactory.smsSender().send();
    }
}
