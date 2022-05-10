package com.gamecodeschool.mysnakegame;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.SoundPool;
import android.os.Build;

import java.io.IOException;


public class SoundContext {

    private SoundStrategyInterface strategy;
    private SoundPool mSP;

    SoundContext(){

        findStrategy();

        mSP = strategy.getSoundPool();
    }

    public void findStrategy(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            strategy = new SoundStrategyLolipop();
        }else {
            strategy = new SoundStrategySDK();
        }
    }

    // It might be worth learning how to use handlers to separate concerns more
    public int initSound(Context context, String soundFile){

        try {
            AssetManager assetManager = context.getAssets();
            AssetFileDescriptor descriptor;

            // Prepare the sounds in memory
            descriptor = assetManager.openFd(soundFile);
            return  mSP.load(descriptor, 0);

        } catch (IOException e) {
            // Error
            return -1;
        }
    }

    SoundPool getSoundPool(){
        return mSP;
    }
}
