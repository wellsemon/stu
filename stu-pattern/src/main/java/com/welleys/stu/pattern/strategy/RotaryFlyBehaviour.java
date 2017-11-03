package com.welleys.stu.pattern.strategy;

import java.util.logging.Logger;

public class RotaryFlyBehaviour implements  FlyBehaviour {
    private Logger logger = Logger.getLogger(RotaryFlyBehaviour.class.getName());

    public void fly() {
        logger.info("Rotary flying");
    }
}
