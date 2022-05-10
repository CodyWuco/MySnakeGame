package com.gamecodeschool.mysnakegame;

import android.media.AudioManager;
import android.media.SoundPool;

public class SoundStrategySDK implements SoundStrategyInterface {

    private SoundPool mSP;

    SoundStrategySDK(){
        setSoundPool();
    }

    private void setSoundPool() {
        mSP = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
    }

    public SoundPool getSoundPool() {
        return mSP;
    }
}
