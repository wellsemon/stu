package com.welleys.stu.pattern.factory.method.multi;

import com.welleys.stu.pattern.factory.method.simple.MailSender;
import com.welleys.stu.pattern.factory.method.simple.SmsSender;

/**
 * sender factory including multi-factory-method
 *
 * @author suzw1
 * @date 2018/07/11.
 */
class SendersFactory {
    /**
     * new instance
     *
     * @return {@link MailSender}
     */
    static MailSender mailSender() {
        return new MailSender();
    }

    /**
     * new instance
     *
     * @return {@link SmsSender}
     */
    static SmsSender smsSender() {
        return new SmsSender();
    }
}
