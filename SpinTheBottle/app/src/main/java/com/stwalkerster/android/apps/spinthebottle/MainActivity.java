package com.stwalkerster.android.apps.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;


import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Declare Variables
        ImageView bottle;
        TextView txt;
        boolean moving;
        int lastDir;
        Random ran = new Random();
        SoundPool soundPool;
        int s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting up SoundPool

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(8)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }
        else {
            soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        }

        //Set Bottle sound to s1
        s1 = soundPool.load(this,R.raw.effect,1);




        //Giving Ids to Them
            bottle =findViewById(R.id.bottle);
            txt = findViewById(R.id.txt);
    }

    //Method Contain Animation
    public void bottleSpinner(View v) {
        if (!moving) {
           //Set new random Direction
            int newDir = ran.nextInt(2000);

            //Starting point of image in x axis
            float pivotx = bottle.getWidth() / 2;

            //Starting point of image in y axis
            float pivoty = bottle.getHeight() / 2;

            //Defining Animation

            Animation spin = new RotateAnimation(lastDir, newDir, pivotx, pivoty);

            //Set duration
            spin.setDuration(2200);

            //When set to true , the animation transformation is applied after the animation is over
            spin.setFillAfter(true);

          //Set Listener on Animation
            spin.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    txt.setVisibility(View.INVISIBLE);
                    moving = true;
                    //Start sound
                    soundPool.play(s1,1,1,1,2,0);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    txt.setVisibility(View.VISIBLE);
                        moving =false;
                        //Pause sound
                        soundPool.autoPause();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDir = newDir;

            //Start Animation
            bottle.startAnimation(spin);
        }
    }


}
