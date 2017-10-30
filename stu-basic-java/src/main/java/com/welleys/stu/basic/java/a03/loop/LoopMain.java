package com.welleys.stu.basic.java.a03.loop;

import java.util.logging.Logger;

public class LoopMain {
    private static Logger l = Logger.getLogger(LoopMain.class.getName());

    public static void main(String[] args) {
        forloopnotexec();
        l.info("======");
        forloop();
        l.info("======");
        whileloop();
        l.info("======");
        dowhileloop();
        l.info("======");
        forloopcontinue();
    }

    private static void forloopcontinue() {
        for (int aa = 0; aa < 10; aa++) {
            if (4 == aa || 5 == aa || 9 == aa){
                l.info("loop num:" + aa + ", skipped");
                continue;
            }
            l.info("loop num:" + aa + ", aa=" + aa);
        }
    }

    private static void dowhileloop() {
        int aa = 3;
        do {
            l.info("loop num:" + (aa - 2) + ", aa=" + aa);
            aa++;
        } while (aa < 9);
    }

    private static void whileloop() {
        int aa = 3;
        while (aa < 9) {
            l.info("loop num:" + (aa - 2) + ", aa=" + aa);
            aa++;
        }
    }

    private static void forloop() {
        for (int aa = 3; aa < 9; aa++)
            l.info("loop num:" + (aa - 2) + ", aa=" + aa);
    }

    private static void forloopnotexec() {
        for (int i = 0; 1 <= i; i--) {
            System.out.println(i);// not output
        }
    }
}

