package com.welleys.stu.pattern.watcher;

import java.util.Date;
import java.util.logging.Logger;

public class ObserverB implements  IObserver {
    private static Logger logger = Logger.getLogger(ObserverB.class.getName());

    public void update(Date date, double salary) {
        logger.info("ObserverB:"+date+"-"+salary);
    }
}
