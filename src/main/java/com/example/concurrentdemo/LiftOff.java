package com.example.concurrentdemo;

/**
 * @author 郭文文
 * @version 1.0
 * @date 2020/11/1 17:51
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    };

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!" )+ "),";
    }

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.print(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
//        Thread thread = new Thread(new LiftOff());
//        thread.start();
        System.out.println("Waiting for Liftoff!");
    }
}
