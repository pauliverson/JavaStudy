package com.hjy.LearnStudy.JavaStudy.DesingPattern.BridgePatter;

/**
 * @author huangjunyan
 * @date 2019-07-11 12:13
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Red circle - "+"radius: "+radius+" x: "+x+" y: "+y);
    }

}
