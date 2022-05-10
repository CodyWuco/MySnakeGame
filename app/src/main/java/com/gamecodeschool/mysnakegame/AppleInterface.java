package com.gamecodeschool.mysnakegame;

import android.graphics.Canvas;
import android.graphics.Paint;

public interface AppleInterface {

    void setPoints(int points);

    int getPoints();

    void setImage(int drawable);

    void spawn();

    void draw(Canvas canvas, Paint paint);
}
