package com.hjy.LearnStudy.JavaStudy.DesingPattern.BridgePatter;

/**
 * @author huangjunyan
 * @date 2019-07-11 12:14
 */
public class BlueCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Blue circle - "+"radius: "+radius+" x: "+x+" y: "+y);
    }

}
