package com.experis.smartrac.b;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

public class TrainingActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private SharedPreferences.Editor prefsEditor;
    private ProgressDialog progressDialog;
    private  WebView mywebview;
    private ImageView viewAttendancetopbarbackImageViewID,viewAttendancetopbarusericonImageViewID;
    private  String url="",userid="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.view_attendance_topbar_training);

        initAllViews();




        //Back Button
        viewAttendancetopbarbackImageViewID.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        viewAttendancetopbarusericonImageViewID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TrainingActivity.this, TrainingActivity.class);
                startActivity(i);
            }
        });



    }//onCreate()





    private void initAllViews(){

        //shared preference
        prefs = getSharedPreferences(CommonUtils.PREFERENCE_NAME,MODE_PRIVATE);
        prefsEditor = prefs.edit();

        viewAttendancetopbarbackImageViewID = (ImageView)findViewById(R.id.viewAttendancetopbarbackImageViewID);
        viewAttendancetopbarusericonImageViewID=(ImageView)findViewById(R.id.viewAttendancetopbarusericonImageViewID);


        //Progress Dialog
        progressDialog = new ProgressDialog(TrainingActivity.this);

        userid=prefs.getString("USERISDCODE","");
      //  url ="http://hmd.smartrac.manpoweronline.in/index.php/login";
        url="https://www.manpoweronline.in/appres/posh_b.aspx?ec="+userid;
         mywebview = (WebView) findViewById(R.id.webView);
        mywebview.loadUrl(url);
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }




    @Override
    public void onBackPressed()
    {
       // super.onBackPressed();
       TrainingActivity.this.finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onDestroy() {
        try {
            if((progressDialog != null) && progressDialog.isShowing() ){
                progressDialog.dismiss();
            }
        }catch (final Exception e) {
            e.printStackTrace();
        } finally {
            progressDialog = null;
        }

        super.onDestroy();
    }



}//ViewAttendanceActivity
