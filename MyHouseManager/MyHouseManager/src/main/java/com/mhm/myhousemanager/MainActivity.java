package com.mhm.myhousemanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText userName,password;
    private CheckBox rem_pw,auto_login;
    private Button btn_login,btn_quit;
    private String userNameValue,passwordValue;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        sp=this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);
        userName=(EditText)findViewById(R.id.tb_name);
        password=(EditText)findViewById(R.id.tb_pass);
        rem_pw=(CheckBox)findViewById(R.id.cb_pass);
        auto_login=(CheckBox)findViewById(R.id.cb_auto);
        btn_login=(Button)findViewById(R.id.btn_OK);
        btn_quit=(Button)findViewById(R.id.btn_cancel);



        if(sp.getBoolean("isCheck",false))
        {
            rem_pw.setChecked(true);
            userName.setText(sp.getString("USER_NAME",""));
            password.setText(sp.getString("PASSWORD",""));
            if(sp.getBoolean("AUTO_isCheck",false))
            {
                auto_login.setChecked(true);
                Intent intent=new Intent(MainActivity.this,Loading.class);
                MainActivity.this.startActivity(intent);
            }
        }
        btn_login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                userNameValue=userName.getText().toString();
                passwordValue=password.getText().toString();

                md5 MD5=new md5();
                MD5.main(passwordValue);
                String PasswordValue=MD5.newpassword;
                MD5.main(userNameValue);
                String UserNameValue=MD5.newpassword;
                if(UserNameValue.equals("21232f297a57a5a743894a0e4a801fc3")&&PasswordValue.equals("81dc9bdb52d04dc20036dbd8313ed055"))
                {
                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();;
                    if(rem_pw.isChecked())
                    {
                        Editor editor=sp.edit();
                        editor.putString("USER_NAME",userNameValue);
                        editor.putString("PASSWORD",passwordValue);
                        editor.commit();
                    }
                    Intent intent=new Intent(MainActivity.this,Loading.class);
                    MainActivity.this.startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"用户名或密码错误，请重新登录！",Toast.LENGTH_LONG).show();
                }
            }
        });
        rem_pw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(rem_pw.isChecked()){
                    System.out.println("记住密码已选中");
                    sp.edit().putBoolean("isCheck",true).commit();
                }
                else
                {
                    System.out.println("记住密码未选中");
                    sp.edit().putBoolean("isCheck",false).commit();
                }

            }
        });
        auto_login.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(auto_login.isChecked())
                {
                    System.out.println("自动登录已选中");
                    sp.edit().putBoolean("AUTO_isCheck",true).commit();
                }
                else
                {
                    System.out.println("自动登录未选中");
                    sp.edit().putBoolean("AUTO_isCheck",false).commit();
                }


            }
        });
        btn_quit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
