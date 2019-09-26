package com.hjy.LearnStudy.JavaStudy.DesingPattern.BridgePatter;


import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjunyan
 * @date 2019-07-11 12:16
 */
public class BridgePatternMain {
    public static void main(String[] args) {
        Shape redCircle = new Circle(10,10,10,new RedCircle());
        Shape blueCircle = new Circle(20,20,20,new BlueCircle());
        Circle circle = new Circle(10,20,20,new RedCircle());
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<String> list2 = new ArrayList<>();
        list2.add("str1");
        list2.add("str2");
        circle.test(list1);
        circle.test(list2);
        circle.printInfo("test");
        circle.printInfo(111.0);
        circle.printPair("xi",1);
        circle.printPair(123,"hhh");
//        UserModel userModel = new UserModel();
//        circle.print(userModel);
//        circle.printInfo(userModel);
        redCircle.draw();
        blueCircle.draw();
    }
}
