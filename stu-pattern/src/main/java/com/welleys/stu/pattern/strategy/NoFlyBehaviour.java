package com.welleys.stu.pattern.strategy;

import java.util.logging.Logger;

public class NoFlyBehaviour implements FlyBehaviour {
    private Logger logger = Logger.getLogger(NoFlyBehaviour.class.getName());
    public void fly() {
        logger.info("No flying");
    }
}
