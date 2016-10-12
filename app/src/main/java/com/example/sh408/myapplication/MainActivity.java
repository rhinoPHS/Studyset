package com.example.sh408.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyView mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mv = new MyView(this);
        setContentView(mv);

        mv.setOnTouchListener(lis);
    }

    View.OnTouchListener lis = new View.OnTouchListener() {
        @Override
            public boolean onTouch(View v, MotionEvent event) {
                mv.setX((int)event.getX());
                mv.setY((int)event.getY());
                v.invalidate();
                return false;
            }

    };

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        x = (int)event.getX();
//        y = (int)event.getY();
//        invalidate();
//        return super.onTouchEvent(event);
//    }
}
