package com.bit.future_demo;

import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Task task = new Task();
        Future<Integer> result = null;
        try {
            result = executor.submit(task);
            while (!task.getIsFinished()) {
                System.out.println("waiting.....");
                Thread.sleep(1000);
            }
            System.out.println("task运行结果" + result.get());
            if(!executor.isShutdown()) {
                executor.shutdown();
            }
            System.out.println("done.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Task implements Callable<Integer> {
    private volatile boolean isFinished = false;

    public boolean getIsFinished() {
        return isFinished;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            throw e;
        }
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        isFinished = true;
        return sum;
    }
}
