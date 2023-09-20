package com.experis.smartrac.b;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class LargerSelfieImageDisplayActivity extends AppCompatActivity {

    private ImageView largerSelfieImageViewID;
    private Intent intent;
    private ImageLoader imageLoader;
    private String path = "";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.larger_selfie_in_approve_attendance);

            largerSelfieImageViewID = (ImageView)findViewById(R.id.largerSelfieImageViewID);
            imageLoader = new ImageLoader(this);

            intent = getIntent();
            path = intent.getStringExtra("IMAGEPATH");
            System.out.println("Image Path In LargerSelfieImageDisplayActivity: "+path);

            largerSelfieImageViewID.setImageBitmap(imageLoader.getBitmap(path));


        }//onCreate()

    public void onBackPressed(){
        LargerSelfieImageDisplayActivity.this.finish();
    }

}//Main Class
