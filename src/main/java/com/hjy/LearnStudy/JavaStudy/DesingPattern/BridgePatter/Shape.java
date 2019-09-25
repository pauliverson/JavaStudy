package com.hjy.LearnStudy.JavaStudy.DesingPattern.BridgePatter;

/**
 * @author huangjunyan
 * @date 2019-07-11 12:07
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }
    abstract void draw();
}
