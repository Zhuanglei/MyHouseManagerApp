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
public class Controls extends Activity{
    private Button btn_account;
    private Button btn_air;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        btn_air=(Button)findViewById(R.id.btn_Menu_air);

        btn_air.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(Controls.this,control.class);
                Controls.this.startActivity(intent);
            }
        });


        btn_account=(Button)findViewById(R.id.btn_Menu_account);

        btn_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(Controls.this,number.class);
                Controls.this.startActivity(intent);
            }
        });


        }
}
