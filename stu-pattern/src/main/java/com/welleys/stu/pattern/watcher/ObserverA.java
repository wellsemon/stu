package com.welleys.stu.pattern.watcher;

import java.util.Date;
import java.util.logging.Logger;

public class ObserverA implements  IObserver {
    private static Logger logger = Logger.getLogger(ObserverA.class.getName());

    public void update(Date date, double salary) {
        logger.info("ObserverA:"+date+"-"+salary);
    }
}
