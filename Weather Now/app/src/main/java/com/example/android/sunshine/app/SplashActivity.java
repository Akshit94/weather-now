package com.example.android.sunshine.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class SplashActivity extends Activity {
    Animation splashAnimation;
    Animation splashAnimation2;
    TextView splashText;
    ImageView splashImage;
    int[] imageArray;
    int currentIndex = 0;
    int startIndex;
    int endIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashText = (TextView) findViewById(R.id.splash_textView);
        splashImage = (ImageView) findViewById(R.id.splash_imageView);

        imageArray = new int[8];
        imageArray[0] = R.drawable.art_clear;
        imageArray[1] = R.drawable.art_clouds;
        imageArray[2] = R.drawable.art_light_rain;
        imageArray[3] = R.drawable.art_rain;
        imageArray[4] = R.drawable.art_fog;
        imageArray[5] = R.drawable.art_light_clouds;
        imageArray[6] = R.drawable.art_snow;
        imageArray[7] = R.drawable.art_storm;

        startIndex = 0;
        endIndex = 7;

        splashAnimation2 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        splashText.startAnimation(splashAnimation2);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Xoxoxa.ttf");
        splashText.setTypeface(typeFace);
        nextImage();
    }

    public void nextImage() {
        splashImage.setImageResource(imageArray[currentIndex]);
        splashAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        splashImage.startAnimation(splashAnimation);

        currentIndex++;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentIndex > endIndex) {
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            finish();
                } else {
                    nextImage();
                }

            }
        }, 1000); // here 1000(1 second) interval to change from current  to next image

    }

}
