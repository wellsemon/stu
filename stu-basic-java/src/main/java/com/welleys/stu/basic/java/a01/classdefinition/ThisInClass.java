package com.welleys.stu.basic.java.a01.classdefinition;

import java.util.logging.Logger;

public class ThisInClass {
    private Logger logger = Logger.getLogger(ThisInClass.class.getName());
    private String str = "hi";
    public ThisInClass() {
    }

    public ThisInClass(String str){
        str = str;
    }

    private void logStr(){
        logger.info(str);
    }

    public static void main(String[] args) {
        new ThisInClass("bye").logStr();
    }
}
