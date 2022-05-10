package com.gamecodeschool.mysnakegame;


import android.graphics.Point;

public class GameObject {

    // The location of the apple on the grid
    // Not in pixels
    protected Point location = new Point();

    GameObject(){
        // Hide the apple off-screen until the game starts
        location.x = -10;
    }

    Point getLocation(){
        return location;
    }

}
