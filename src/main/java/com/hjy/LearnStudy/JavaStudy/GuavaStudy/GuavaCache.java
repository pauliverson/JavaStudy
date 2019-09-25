package com.hjy.LearnStudy.JavaStudy.GuavaStudy;

import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;

/**
 * @author huangjunyan
 * @date 2019-08-11 01:40
 */
public class GuavaCache {
//    public static void main(String[] args) {
//
//        RemovalListener<String, Integer> listener = new RemovalListener<String, Integer>() {
//            @Override
//            public void onRemoval(RemovalNotification<String, Integer> removalNotification) {
//                System.out.println("[" + removalNotification.getKey() + ":" + removalNotification.getValue() + "] is removed!");
//            }
//        };
//        Cache<String, Integer> cache = CacheBuilder.newBuilder()
//                .maximumSize(2)
//                .removalListener(listener)
//                .build();
//        cache.put("key1", 1);
//        cache.put("key2", 2);
//        cache.put("key3", 3);
//        System.out.println(cache.getIfPresent("key1"));
//        System.out.println(cache.getIfPresent("key2"));
//        System.out.println(cache.getIfPresent("key3"));
//
////        Optional<String> fullName = Optional.of("Tom");
////        System.out.println(fullName.isPresent());
////        System.out.println(fullName.orElse("Null"));
////        System.out.println(fullName.map(s -> "Hey" + s + "!").orElse("Hey Stranger!"));
//    }
    private static Cache<String, String> cache = CacheBuilder
        .newBuilder()
        .maximumSize(3)
        .build();
    public static void main(String[] args) {
//        new Thread(() -> {
//            System.out.println("Thread 1");
//            try {
//                String value = cache.get("key",() -> {
//                    System.out.println("load1");
//                    Thread.sleep(1000);
//                    return "auto load by cache";
//                });
//                System.out.println("Thread 1 " + value);
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(() -> {
//            System.out.println("Thread 2");
//            try {
//                String value = cache.get("key",() -> {
//                    System.out.println("load2");
//                    Thread.sleep(1000);
//                    return "auto load by cache";
//                });
//                System.out.println("Thread 2 " + value);
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }).start();

        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            @Override
            public String load(String s) throws Exception {
                Thread.sleep(1000);
                System.out.println(s + " is loaded from a cacheLoader!");
                return s + "'s value";
            }
        };

        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build(loader);

        try {
            loadingCache.get("key1");
            loadingCache.get("key2");
            loadingCache.get("key3");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
