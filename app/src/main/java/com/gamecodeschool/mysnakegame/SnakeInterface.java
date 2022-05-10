package com.gamecodeschool.mysnakegame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;


interface SnakeInterface {

    // Get the snake ready for a new game
    void reset();

    void move();

    boolean detectDeath();

    boolean checkDinner(Point apple);

    void draw(Canvas canvas, Paint paint);

    // Handle changing direction
    void switchHeading(MotionEvent motionEvent);
}