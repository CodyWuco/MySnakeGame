package com.gamecodeschool.mysnakegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;

public class SnakeSegment extends GameObject implements SnakeInterface {

    // used to treat Snake as a linked list
    protected SnakeSegment nextSegment;

    // How big is each segment of the snake?
    protected int mSegmentSize;


    // A bitmap for the body
    private Bitmap mBitmapBody;

    SnakeSegment(Context context, Point mr, int ss){
        // Initialize the segment size and location
        // from the passed in parameters
        mSegmentSize = ss;
        location = mr;

        // Create and scale the body
        mBitmapBody = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.body);

        mBitmapBody = Bitmap
                .createScaledBitmap(mBitmapBody,
                        ss, ss, false);
    }

    @Override
    public void reset() {

    }


    @Override
    public void move() {
        location.x = nextSegment.location.x;
        location.y = nextSegment.location.y;
        if (nextSegment != null){
            nextSegment.move();
        }
    }

    // need to find a way to get rid of this first one
    @Override
    public boolean detectDeath() {
        return false;
    }

    // used to recursively check interactions with the head of the snake the the body
    public boolean detectDeath(SnakeSegment snakeHead) {
        if (snakeHead.location.x == this.location.x &&
                snakeHead.location.y == this.location.y) {
            return true;
        }
        return nextSegment.detectDeath(snakeHead);
    }

    // this should only be part of the head and composite
    @Override
    public boolean checkDinner(Point apple) {
        return false;
    }

    public void draw(Canvas canvas, Paint paint) {
        if (nextSegment != null) {
            nextSegment.draw(canvas, paint);
        }
        // All the code from this method goes here
            // Draw the head
        canvas.drawBitmap(mBitmapBody,
                location.x
                        * mSegmentSize,
                location.y
                        * mSegmentSize, paint);
    }

    // this should only be part of the head and composite
    @Override
    public void switchHeading(MotionEvent motionEvent) {

    }
}
