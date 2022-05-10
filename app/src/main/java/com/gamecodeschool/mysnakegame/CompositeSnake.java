package com.gamecodeschool.mysnakegame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;


public class CompositeSnake implements SnakeInterface {

    private SnakeSegment snakeHead;

    private SnakeSegment compSnake;

    // How big is each segment of the snake?
    private int mSegmentSize;

    // How big is the entire grid
    private Point mMoveRange;

    Context context;

    CompositeSnake(Context context, Point mr, int ss) {
        this.context = context;

        // Initialize the segment size and movement
        // range from the passed in parameters
        mSegmentSize = ss;
        mMoveRange = mr;

    }

    // Get the snake ready for a new game
    public void reset() {

        compSnake = null;

        // Start with a single snake segment
        addSnakeHead();

        snakeHead = compSnake;
    }

    private void addSnakeHead(){
        addToSnake(new SnakeHead(this.context, mMoveRange, mSegmentSize));
    }

    private void addSnakeSegment(){
        addToSnake(new SnakeSegment(this.context, new Point(-10,-10), mSegmentSize));
    }

    private void addToSnake(SnakeSegment snakeSegment){
        snakeSegment.nextSegment = compSnake;
        compSnake = snakeSegment;
    }


    public void move() {
        // recursive move call
        compSnake.move();
    }

    public boolean detectDeath() {
        // Has the snake died?
        return detectDeath(snakeHead);
    }

    public boolean detectDeath(SnakeSegment snakeHead) {
        return compSnake.detectDeath(snakeHead);
    }


    public boolean checkDinner(Point l) {
        //if (snakeXs[0] == l.x && snakeYs[0] == l.y) {
        if (snakeHead.location.x == l.x &&
                snakeHead.location.y == l.y) {

            // Add a new Point to the list
            // located off-screen.
            // This is OK because on the next call to
            // move it will take the position of
            // the segment in front of it
            addSnakeSegment();
            return true;
        }
        return false;
    }

    public void draw(Canvas canvas, Paint paint) {

        if (compSnake != null) {
            compSnake.draw(canvas, paint);
        }
    }


    // Handle changing direction
    public void switchHeading(MotionEvent motionEvent) {
        snakeHead.switchHeading(motionEvent);
    }
}
