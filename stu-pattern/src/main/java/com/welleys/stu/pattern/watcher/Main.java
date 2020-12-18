package com.welleys.stu.pattern.watcher;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class Main {
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
        log.info("after delObserverB.......");
        subject.setSubject(new Date(), 33.33d);
        Thread.sleep(1000);
        subject.setSubject(new Date(), 44.44d);
        Thread.sleep(1000);
    }
}
