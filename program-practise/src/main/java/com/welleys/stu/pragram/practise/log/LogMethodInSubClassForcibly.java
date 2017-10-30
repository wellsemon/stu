package com.welleys.stu.pragram.practise.log;

import java.util.logging.Logger;

/**
 * every subclass must implements logger method,
 * but repeated work increases over time, and code is difficult to maintain
 */
public abstract  class LogMethodInSubClassForcibly {
    protected abstract Logger logger();
}
