package com.example.toast;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button simple = findViewById(R.id.simple);
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this,"简单的提示信息",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        Button btn_image = findViewById(R.id.btn_image);
        btn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(MainActivity.this);
                toast.setGravity(Gravity.CENTER,0,0);
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.tools);
                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.addView(imageView);
                TextView textView = new TextView(MainActivity.this);
                textView.setText("带图片的提示信息");
                textView.setTextSize(24);
                textView.setTextColor(Color.MAGENTA);
                linearLayout.addView(textView);
                toast.setView(linearLayout);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
        Button btn_only_image = findViewById(R.id.btn_only_image);
        btn_only_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(MainActivity.this);
                toast.setGravity(Gravity.CENTER,0,0);
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.tools);
                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.addView(imageView);
                toast.setView(linearLayout);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
