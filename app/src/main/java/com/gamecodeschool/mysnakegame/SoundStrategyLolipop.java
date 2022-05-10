package com.gamecodeschool.mysnakegame;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class SoundStrategyLolipop implements SoundStrategyInterface {

    private SoundPool mSP;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    SoundStrategyLolipop(){
        setSoundPool();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setSoundPool() {

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        mSP = new SoundPool.Builder()
                .setMaxStreams(5)
                .setAudioAttributes(audioAttributes)
                .build();
    }

    @Override
    public SoundPool getSoundPool() {
        return mSP;
    }
}
