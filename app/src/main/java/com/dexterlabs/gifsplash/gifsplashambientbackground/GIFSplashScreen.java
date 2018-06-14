package com.dexterlabs.gifsplash.gifsplashambientbackground;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class GIFSplashScreen extends AppCompatActivity {

    private GifImageView gifImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifsplash_screen);

        gifImageView =(GifImageView)findViewById(R.id.gifImageView);

        try {
            InputStream inputStream=getAssets().open("gear-animation.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
         catch (IOException e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
           GIFSplashScreen.this.startActivity(new Intent(GIFSplashScreen.this ,MainActivity.class));
           GIFSplashScreen.this.finish();
            }
        },3000);

    }
}
