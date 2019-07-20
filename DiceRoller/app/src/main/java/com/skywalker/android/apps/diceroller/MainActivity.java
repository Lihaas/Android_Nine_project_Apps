package com.skywalker.android.apps.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView diceONE, diceTwo;
    LinearLayout layout;


    // ImageView bottle;
    // TextView txt;
    boolean moving;
    int lastDir;
    Random ran = new Random();
    SoundPool soundPool;
    int s1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceONE = findViewById(R.id.diceOne);
        diceTwo = findViewById(R.id.diceTwo);
      //  layout = findViewById(R.id.layoutfile);

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
        s1 = soundPool.load(this,R.raw.roll,1);



        diceONE.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        DiceSpinOne();
        DiceSpinTwo();


    }
});
        diceTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiceSpinOne();
                DiceSpinTwo();


            }
        });




    }


    public void DiceSpinOne() {
        if (!moving) {


            //Starting point of image in x axis
            float pivotx = diceONE.getWidth() / 1;

            //Starting point of image in y axis
            float pivoty = diceONE.getHeight() / 1;

            //Defining Animation

            Animation spin = new RotateAnimation(1800, 0, pivotx, pivoty);

            //Set duration
            spin.setDuration(2200);

            //When set to true , the animation transformation is applied after the animation is over
            spin.setFillAfter(true);

            //Set Listener on Animation
            spin.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                //    txt.setVisibility(View.INVISIBLE);
                    moving = true;
                    //Start sound
                    soundPool.play(s1, 1, 1, 1, 2, 0);
                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    diceNumberChange();
                //    txt.setVisibility(View.VISIBLE);
                    moving = false;
                    //Pause sound
                   soundPool.autoPause();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

          //  lastDir = newDir;

            //Start Animation
            diceONE.startAnimation(spin);
        }


    }


    public void DiceSpinTwo() {
        if (!moving) {


            //Starting point of image in x axis
            float pivotx = diceTwo.getWidth() / 1;

            //Starting point of image in y axis
            float pivoty = diceTwo.getHeight() / 1;

            //Defining Animation

            Animation spin = new RotateAnimation(0, 1800, pivotx, pivoty);

            //Set duration
            spin.setDuration(2200);

            //When set to true , the animation transformation is applied after the animation is over
            spin.setFillAfter(true);

            //Set Listener on Animation
            spin.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    //    txt.setVisibility(View.INVISIBLE);
                    moving = true;
                    //Start sound
                    //               soundPool.play(s1, 1, 1, 1, 2, 0);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    //    txt.setVisibility(View.VISIBLE);
                    moving = false;
                    //Pause sound
                    //             soundPool.autoPause();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            //  lastDir = newDir;

            //Start Animation
            diceTwo.startAnimation(spin);
        }


    }

    public  void diceNumberChange(){

        int dice1 = (ran.nextInt(5));
        int dice2 = (ran.nextInt(5));


        switch (dice1){

            case 0 : diceONE.setImageResource(R.drawable.dic1);
                        break;
            case 1 : diceONE.setImageResource(R.drawable.dic2);
                break;
            case 2 : diceONE.setImageResource(R.drawable.dic3);
                break;
            case 3 : diceONE.setImageResource(R.drawable.dic4);
                break;
            case 4 : diceONE.setImageResource(R.drawable.dic5);
                break;
            case 5 : diceONE.setImageResource(R.drawable.dic6);
                break;

        }

        switch (dice2){

            case 0 : diceTwo.setImageResource(R.drawable.dic1);
                break;
            case 1 : diceTwo.setImageResource(R.drawable.dic2);
                break;
            case 2 : diceTwo.setImageResource(R.drawable.dic3);
                break;
            case 3 : diceTwo.setImageResource(R.drawable.dic4);
                break;
            case 4 : diceTwo.setImageResource(R.drawable.dic5);
                break;
            case 5 : diceTwo.setImageResource(R.drawable.dic6);
                break;

        }







    }



}
