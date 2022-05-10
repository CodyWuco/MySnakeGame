package com.gamecodeschool.mysnakegame;

import android.content.Context;
import android.graphics.Point;

import java.util.Random;

public class AppleBuilder implements AppleBuilderInterface {

    public Apple apple;

    private Context context;
    private Point sr;
    private int s;

    AppleBuilder(Context context, Point sr, int s){
        this.context = context;
        this.sr = sr;
        this.s = s;
    }

    public void reset(){
        apple = new Apple(context, sr, s);
    }

    public void setPointRange(int min, int max) {
        apple.setPoints(new Random().nextInt(max - min +1) + min);
    }

    public void setImage(int drawable) {
        apple.setImage(drawable);
    }

    public Apple getApple(){
        return this.apple;
    }
}
