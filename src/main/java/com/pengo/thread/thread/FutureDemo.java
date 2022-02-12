package com.pengo.thread.thread;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author pengo
 * @description:
 * @date 2022/2/12 23:03
 */
public class FutureDemo {
    public static void main(String[] args) throws Exception{
        test4();
    }

    static void test4() throws Exception{
//        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> queryCode("中国石油", "http://sina.com"));
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return queryCode("中国石油", "http://sina.com");
            }
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> queryCode("中国石油", "http://163.com"));
        CompletableFuture<Object> cf3 = CompletableFuture.anyOf(cf1, cf2);
//        CompletableFuture<Object> cf4 = cf3.thenApplyAsync((code) -> {
//            return fetchPrice((String) code, "http://sina.com");
//        });
        CompletableFuture<Double> cf4 = cf3.thenApplyAsync(new Function<Object, Double>() {
            @Override
            public Double apply(Object o) {
                return fetchPrice((String) o, "http://sina.com");
            }
        });
        CompletableFuture<Double> cf5 = cf3.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "http://163.com");
        });
        CompletableFuture<Object> cf6 = CompletableFuture.anyOf(cf4, cf5);
        cf6.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        Thread.sleep(2000);

    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }

    static void test3() throws Exception{
//        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
//            return queryCode("中国石油");
//        });
//        CompletableFuture<Double> cf2 = cf1.thenApplyAsync((code) -> {
//            return fetchPrice(code);
//        });
//        cf2.thenAccept((result) -> {
//            System.out.println("price: " + result);
//        });
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return queryCode("中国石油");
            }
        });
        CompletableFuture<Double> cf2 = cf1.thenApplyAsync(new Function<String, Double>() {
            @Override
            public Double apply(String s) {
                return fetchPrice(s);
            }
        });
        cf2.thenAccept(new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("price: " + aDouble);
            }
        });
        Thread.sleep(2000);
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }

    static void test2() throws Exception{
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(FutureDemo::fetchPrice);
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return 0.00;
        });
        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }

    static void test1() throws Exception{
        long now = System.currentTimeMillis();
        System.out.println(now);
        ExecutorService es = Executors.newFixedThreadPool(4);
        Future<BigDecimal> future = es.submit(new Task2("601857"));
        BigDecimal bigDecimal = future.get();
        System.out.println(bigDecimal);
        es.shutdown();
        System.out.println("cost: " + (System.currentTimeMillis() - now));
    }
}

class Task2 implements Callable<BigDecimal> {

    public Task2(String code) {
    }

    @Override
    public BigDecimal call() throws Exception {
        Thread.sleep(1000);
        double d = 5 + Math.random() * 20;
        return new BigDecimal(d).setScale(2, RoundingMode.DOWN);
    }
}