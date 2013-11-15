package com.mhm.myhousemanager;

/**
 * Created by admin on 13-11-15.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

import org.w3c.dom.Text;

public class number extends Activity{

    private SharedPreferences share;//声明SharedPreferences
  //  private TextView Oldname,Oldpassword;
    private Button num_ok,num_cancel;
    private EditText Newname,Newpassword;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alter);

       share=getSharedPreferences("info",Activity.MODE_PRIVATE);


       // Oldname=(TextView)findViewById(R.id.oldname );
       // Oldpassword=(TextView)findViewById(R.id.oldpassword );
        Newname=(EditText)findViewById(R.id.newname );
        Newpassword=(EditText)findViewById(R.id.newpassword );
        num_ok=(Button )findViewById(R.id.number_ok );
        num_cancel=(Button )findViewById(R.id.number_cancel );



        num_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=Newname.getText().toString();
                String pass=Newpassword .getText().toString();

                md5 MD5=new md5();
                MD5.main(name);
                String NAME=MD5.newpassword;
                MD5.main(pass);
                String PASS=MD5.newpassword;

                Editor edit=share.edit();
                edit.putString("NEWUSER_NAME", NAME);
                edit.putString("NEWPASSWORD", PASS);
                edit.commit();
                //提示成功注册
                Toast.makeText(number.this, "恭喜，成功", Toast.LENGTH_LONG).show();

            }
        });


        num_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}
