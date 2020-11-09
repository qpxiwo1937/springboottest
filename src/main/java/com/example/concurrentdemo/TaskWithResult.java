package com.example.concurrentdemo;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author 郭文文
 * @version 1.0
 * @date 2020/11/1 18:27
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult" + id;
    }
}

class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> f : futures) {
            try {
                //使用isDone判断任务是否完成
                if (f.isDone()) {
                    System.out.println(f.get());
                } else {
                    System.out.println("还未完成！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }
}
