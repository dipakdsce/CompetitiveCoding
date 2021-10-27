package com.MultiThreading.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread cacheService = new Thread(new Service("CacheService", 1000, countDownLatch));
        Thread alertService = new Thread(new Service("AlertService", 1000, countDownLatch));
        Thread validationService = new Thread(new Service("ValidationService", 1000, countDownLatch));
        cacheService.start();
        alertService.start();
        validationService.start();
        try {
            countDownLatch.await();
            System.out.println("All Services are up, application is starting now");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
