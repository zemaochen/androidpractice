package com.example.alertdialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class result extends Activity {
    private String username;
    private String password;
    private String tel;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        password = intent.getStringExtra("password");
        tel = intent.getStringExtra("tel");
        TextView user = (TextView)findViewById(R.id.user);
        user.setText(username);
        TextView pwd = (TextView)findViewById(R.id.pwd);
        pwd.setText(password);
        TextView phone = (TextView)findViewById(R.id.phone);
        phone.setText(tel);
    }
}
