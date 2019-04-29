package com.cdu.plane;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    private int speed = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//去除窗口标题

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//全屏显示

        final PlaneView planeView = new PlaneView(this);

        setContentView(planeView);

        planeView.setBackgroundResource(R.drawable.background);

        WindowManager windowManager = getWindowManager();

        Display display = windowManager.getDefaultDisplay();

        DisplayMetrics displayMetrics = new DisplayMetrics();

        display.getMetrics(displayMetrics);//获得屏幕的宽和高

        planeView.currentX1 = displayMetrics.widthPixels/2-planeView.plane1.getWidth()/2;
        planeView.currentY1 = displayMetrics.widthPixels/2+planeView.plane1.getHeight()/2;
        planeView.currentX2 = displayMetrics.widthPixels/2-planeView.plane2.getWidth()/2;
        planeView.currentY2 = displayMetrics.widthPixels/2-planeView.plane2.getHeight()/2;

        planeView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (event.getKeyCode()){
                    case KeyEvent.KEYCODE_S:
                        planeView.currentY2 += speed;
                        break;
                    case KeyEvent.KEYCODE_W:
                        planeView.currentY2 -= speed;
                        break;
                    case KeyEvent.KEYCODE_A:
                        planeView.currentX2 -= speed;
                        break;
                    case KeyEvent.KEYCODE_D:
                        planeView.currentX2 += speed;
                        break;
                }
                planeView.invalidate();
                return true;
            }
        });

    }
}
