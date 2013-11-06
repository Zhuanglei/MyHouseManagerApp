package com.mhm.myhousemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * Created by ArvinZy on 13-10-24.
 */
public class Loading extends Activity{
    private ProgressBar progressBar;
    private Button backButton;


   protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       this.requestWindowFeature(Window.FEATURE_NO_TITLE);
       setContentView(R.layout.activity_loading);
       progressBar=(ProgressBar)findViewById(R.id.pgBar);
       backButton=(Button)findViewById(R.id.btn_back);
       progressBar.setMax(10000);
       Intent intent=new Intent(Loading.this,Controls.class);
       Loading.this.startActivity(intent);
       backButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });

   }


}
