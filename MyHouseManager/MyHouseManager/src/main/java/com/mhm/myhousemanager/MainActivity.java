package com.mhm.myhousemanager;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    //声明需要的组件
    private  Button login,exit,reg;
    private  EditText   username,password;
    private SharedPreferences share;//声明SharedPreferences
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.btn_OK);
        exit=(Button)findViewById(R.id.btn_cancel);
        username=(EditText)findViewById(R.id.lbl_name);
        password=(EditText)findViewById(R.id.lbl_pass);
        share=getSharedPreferences("info",Activity.MODE_PRIVATE);
        Editor edit=share.edit();
        edit.putString("username", "admin");
        edit.putString("password", "123456");
        edit.commit();
        exit.setOnClickListener(new Listenerimp());//退出的监听事件
        //登陆的事件监听处理内部类
        login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //获取输入的信息
                String name=username.getText().toString();
                String pass=password.getText().toString();
                //判断输入信息是否为空
                if(name.trim().equals("") || pass.trim().equals("")) {
                    Toast.makeText(MainActivity.this, "用户名和密码不能为空", Toast.LENGTH_LONG).show();
                }
                //获取保存文件中的用户名和密码
                String savedUsername = share.getString("username","");
                String savedPassword = share.getString("password","");
                //查看输入的密码和名字是否一致
                if(name.trim().equals(savedUsername) && pass.trim().equals(savedPassword)) {
                    Toast.makeText(MainActivity.this, "恭喜，亲，用户名和密码都正确！", Toast.LENGTH_LONG).show();


                    Intent intent=new Intent(MainActivity.this,control.class);
                    startActivity(intent);
                    finish();

                } else {
                    //错误的话
                    Toast.makeText(MainActivity.this, "用户名或者密码错误，请确认信息或者去注册", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }
    private class Listenerimp implements  OnClickListener{

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            finish();//结束一个Activity
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}



