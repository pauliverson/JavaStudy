//package com.hjy.LearnStudy.JavaStudy.MutipleRoundQuery;
//
//import com.didi.mybatis.demo.entity.OrderModel;
//import com.didi.mybatis.demo.service.OrderService;
//import java.util.TimerTask;
//
///**
// * @author huangjunyan
// * @date 2019-07-04 15:46
// */
//public class MyTask implements ThreadPoolTask.Callback {
//
//    private MyTaskList list;
//    private ThreadPoolTask task;
//    private String tag;
//    private int retry = 0;
//    private String code;
//    private OrderService orderService;
//    public MyTask(MyTaskList list, String tag) {
//        this.list = list;
//        this.tag = tag;
//    }
//
//    public String start(String code,OrderService orderService) {
//        this.code = code;
//        task = new ThreadPoolTask(tag, this);
//        return start(0,code,orderService);
//    }
//
//    private String start(int retry,String code,OrderService orderService) {
//        this.orderService = orderService;
//        System.out.println(tag + " round "+retry + " " + Thread.currentThread());
//        // 最多重试30次
//        if (retry >= 30) {
//            System.out.println(tag + " finished " + Thread.currentThread());
//            OrderModel orderModel = new OrderModel();
//            orderModel.setCode(code);
//            orderModel.setOrderStatus(4);
//            orderService.generateOrder(orderModel);
//            return code + " is canceled";
//        }
//        if(checkOrder(code) == 2) {
//            System.out.println("order "+code+" is finished");
//            return code + " is finished";
//        }else if(checkOrder(code) == 4){
//            System.out.println("order "+code+" is canceled");
//            return code + " is canceled";
//        }
//        this.retry = retry;
//        list.addTask(task);
//        return code + " is getting on";
//    }
//
//    @Override
//    public void onRetry() {
//        // 重试间隔
//        list.addTask(timertask, 1000);
//    }
//
//    private TimerTask timertask = new TimerTask() {
//
//        @Override
//        public void run() {
//            start(retry+1,code,orderService);
//        }
//
//    };
//
//    private int checkOrder(String code) {
//        OrderModel orderModel = orderService.queryOrderStatusByCode(code);
//        int orderStatus = orderModel.getOrderStatus();
//        System.out.println("order "+code+" Status is " +orderStatus);
//        return orderStatus;
//    }
//}
