package com.cdu.viweflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mian);
        viewFlipper = (ViewFlipper)findViewById(R.id.details);
    }
    public void prev(View source){
        viewFlipper.setInAnimation(this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_left);
        viewFlipper.showPrevious();
        viewFlipper.stopFlipping();
    }

    public void down(View source){
        viewFlipper.setInAnimation(this,R.anim.slide_in_up);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_bottom);
        viewFlipper.showPrevious();
        viewFlipper.stopFlipping();
    }
    public void up(View source){
        viewFlipper.setInAnimation(this,R.anim.slide_in_bottom);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_up);
        viewFlipper.showPrevious();
        viewFlipper.stopFlipping();
    }
    public void next(View source){
        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
        viewFlipper.showNext();
        viewFlipper.stopFlipping();

    }

    public void auto(View source){
        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
        viewFlipper.startFlipping();
    }
}
