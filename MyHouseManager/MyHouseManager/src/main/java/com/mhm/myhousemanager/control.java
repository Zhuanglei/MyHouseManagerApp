package com.mhm.myhousemanager;

/**
 * Created by ArvinZy on 13-10-22.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import javax.security.auth.Subject;

public class control extends Activity{

   private CheckBox healthy,makecold,makehot,arefaction,loop,nature;
   private TextView temp,now,wind,name;
   private SeekBar choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air);

        healthy =(CheckBox)findViewById(R.id.cb_Healthy);
        makecold =(CheckBox)findViewById(R.id.cb_makecold);
        makehot =(CheckBox)findViewById(R.id.cb_makehot);
        arefaction =(CheckBox)findViewById(R.id.cb_arefaction);
        loop =(CheckBox)findViewById(R.id.cb_loop);
        nature =(CheckBox)findViewById(R.id.cb_nature);
        temp=(TextView)findViewById(R.id.air_temp);
        now=(TextView)findViewById(R.id.air_now);
        choice=(SeekBar)findViewById(R.id.air_choice);
        wind=(TextView)findViewById(R.id.air_wind);
        name=(TextView)findViewById(R.id.tb_name);

        if(healthy.isChecked()||makecold.isChecked()||makehot.isChecked() ||arefaction.isChecked() ||loop.isChecked()||nature.isChecked())
        {healthy.setChecked(false);makecold.setChecked(false);makehot.setChecked(false);arefaction.setChecked(false);loop.setChecked(false);nature.setChecked(false);}


        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setVisibility(View.VISIBLE);
                choice.setVisibility(View.VISIBLE);
                now.setVisibility(View.VISIBLE);
                name.setText("温度选择");
                now.setText(temp.getText());
            }
        });


        wind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setVisibility(View.VISIBLE);
                choice.setVisibility(View.VISIBLE);
                now.setVisibility(View.VISIBLE);
                name.setText("风速选择");
                now.setText(wind.getText());
            }
        });



    }

}
