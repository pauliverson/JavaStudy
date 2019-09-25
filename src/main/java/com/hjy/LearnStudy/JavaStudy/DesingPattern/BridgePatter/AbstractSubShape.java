package com.hjy.LearnStudy.JavaStudy.DesingPattern.BridgePatter;

/**
 * @author huangjunyan
 * @date 2019-08-08 20:09
 */
public class AbstractSubShape extends Shape{
    protected AbstractSubShape(DrawAPI drawAPI) {
        super(drawAPI);
    }

    @Override
    void draw() {

    }


}
