package com.cdu.plane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class PlaneView extends View {

    public float currentX1;
    public float currentY1;
    public float currentX2;
    public float currentY2;
    Bitmap plane1;
    Bitmap plane2;
    public PlaneView(Context context) {
        super(context);
        plane1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
        plane2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
        setFocusable(true);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(plane1,currentX1,currentY1,p);
        canvas.drawBitmap(plane2,currentX2,currentY2,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX1 = event.getX()-plane1.getWidth()/2;
        currentY1 = event.getY()-plane1.getHeight()/2;
        this.invalidate();//通知组件重绘
        return true;
    }
}
