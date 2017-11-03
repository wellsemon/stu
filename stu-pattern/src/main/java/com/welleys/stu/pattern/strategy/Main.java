package com.welleys.stu.pattern.strategy;

public class Main {
    public static void main(String[] args) {
        Duck rotaryDuck = new RotaryDuck();
        Duck rubberDuck = new RubberDuck();

        FlyBehaviour rotaryFly = new RotaryFlyBehaviour();
        FlyBehaviour noFly = new NoFlyBehaviour();

        rotaryDuck.setFlyBehaviour(rotaryFly);
        rubberDuck.setFlyBehaviour(noFly);

        rotaryDuck.performFly();
        rubberDuck.performFly();
    }
}
