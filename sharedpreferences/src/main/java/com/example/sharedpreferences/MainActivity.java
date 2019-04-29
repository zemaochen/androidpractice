package com.example.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final SharedPreferences preferences;
        final SharedPreferences.Editor editor;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mian);
        preferences = getSharedPreferences("ithema",MODE_PRIVATE);
        editor = preferences.edit();
        Button read = (Button) findViewById(R.id.read);
        Button write = (Button) findViewById(R.id.write);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = preferences.getString("time",null);
                int randNum = preferences.getInt("random",0);
                String result = time ==null?"您暂时还未写入数据":"写入时间为："+time+"\n上次生成的随机数为："+randNum;
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
            }
        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年mm月dd日"+"hh:mm:ss");
                editor.putString("time",sdf.format(new Date()));
                int i = (int)(Math.random()*100);
                editor.putInt("random",i);
                Toast.makeText(MainActivity.this,"数据写入"+i,Toast.LENGTH_SHORT).show();
                editor.commit();
            }
        });
    }
}
