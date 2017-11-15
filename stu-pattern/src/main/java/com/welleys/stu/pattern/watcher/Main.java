package com.welleys.stu.pattern.watcher;

import sun.rmi.runtime.Log;

import java.util.Date;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {
        SubjectSimpleImpl subject = new SubjectSimpleImpl();

        IObserver observerA = new ObserverA();
        IObserver observerB = new ObserverB();

        subject.addObserver(observerA);
        subject.addObserver(observerB);


        subject.setSubject(new Date(), 11.11d);
        Thread.sleep(1000);
        subject.setSubject(new Date(), 22.22d);
        Thread.sleep(1000);

        subject.delObserver(observerB);
        logger.info("after delObserverB.......");
        subject.setSubject(new Date(), 33.33d);
        Thread.sleep(1000);
        subject.setSubject(new Date(), 44.44d);
        Thread.sleep(1000);
    }
}
