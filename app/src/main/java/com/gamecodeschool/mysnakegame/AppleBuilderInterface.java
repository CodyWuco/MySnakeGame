package com.gamecodeschool.mysnakegame;


import android.graphics.drawable.Drawable;

public interface AppleBuilderInterface {

    void reset();

    void setPointRange(int min, int max);

    void setImage(int drawable);

    Apple getApple();
}
