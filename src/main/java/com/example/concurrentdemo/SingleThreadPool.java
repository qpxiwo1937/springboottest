package com.example.concurrentdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 郭文文
 * @version 1.0
 * @date 2020/11/1 18:20
 */
public class SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0;i < 5;i++){
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
