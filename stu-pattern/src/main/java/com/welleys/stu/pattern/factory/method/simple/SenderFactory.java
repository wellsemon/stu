package com.welleys.stu.pattern.factory.method.simple;

/**
 * @author suzw1
 * @date 2018/07/11
 */
class SenderFactory {
  static final String MAIL = "mail";
  static final String SMS = "sms";

  static Sender newInstance(String targetSent) {
    if (MAIL.equals(targetSent)) {
      return new MailSender();
    } else if (SMS.equals(targetSent)) {
      return new SmsSender();
    }

    return null;
  }
}
