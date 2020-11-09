package com.example.concurrentdemo;

import java.util.concurrent.ThreadFactory;

/**
 * @author 郭文文
 * @version 1.0
 * @date 2020/11/1 19:55
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
