package com.gamecodeschool.mysnakegame;

public class AppleDirector {

    private AppleBuilder builder;

    AppleDirector(AppleBuilder builder){
        this.builder = builder;
    }

    public void buildBasicApple(){
        builder.reset();
        builder.setImage(R.drawable.apple);
        builder.setPointRange(1, 1);
    }

    public void buildGoodApple(){
        builder.reset();
        builder.setImage(R.drawable.applegood);
        builder.setPointRange(1, 3);
    }

    public void buildBadApple(){
        builder.reset();
        builder.setImage(R.drawable.applebad);
        builder.setPointRange(-2, -2);
    }

    public void buildChanceGoodOrBad(){
        if (Math.random() < .2){
            buildBadApple();
        }else {
            buildGoodApple();
        }
    }
}
